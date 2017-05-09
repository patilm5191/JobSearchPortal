package com.neu.jobportal.controller;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.dao.CompanyDAO;
import com.neu.jobportal.dao.DAO;
import com.neu.jobportal.dao.RecruiterDAO;
import com.neu.jobportal.dao.UserDAO;
import com.neu.jobportal.exception.UserException;
import com.neu.jobportal.pojo.Candidate;
import com.neu.jobportal.pojo.CompanyDetails;
import com.neu.jobportal.pojo.Recruiter;
import com.neu.jobportal.utils.Encryption;
import com.neu.jobportal.utils.SendEmail;
import com.neu.jobportal.validator.CandidateValidator;
import com.neu.jobportal.validator.RecruiterValidator;
import com.neu.jobportal.validator.SanitizeData;

@Controller
public class RecruiterController {
	
	@Autowired
	@Qualifier("recruiterDao")
	RecruiterDAO recruiterDao;
	
	@Autowired
	@Qualifier("companyDao")
	CompanyDAO companyDao;
	
	@Autowired
	@Qualifier("recruiterValidator")
	RecruiterValidator recruiterValidator;

	@Autowired
	@Qualifier("sanitizeData")
	SanitizeData sanitizeData;
	
	@Autowired
	@Qualifier("sendEmail")
	SendEmail sendEmail;
	
	@Autowired
	JavaMailSender mailSender;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(recruiterValidator);
	}
	
	@RequestMapping(value = "goToRecruiterHomePage.htm", method = RequestMethod.GET)
	protected String goToRecruiterHomePage(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkRecSession(session);
		if (flag == true){
			return "recruiter-homepage";
		}
		else{
			return "homepage";
		}
	}
	
	@RequestMapping(value = "registerRecruiter.htm", method = RequestMethod.GET)
	protected ModelAndView registerRecruiter() throws Exception {
		System.out.print("registerRecruiter");

		return new ModelAndView("register-recruiter", "recruiter", new Recruiter());

	}

//	
//	@RequestMapping(value = "registerRecruiter.htm", method = RequestMethod.POST)
//	protected ModelAndView registerNewRecruiter(HttpServletRequest request){
//		System.out.println("inside registerNewRecruiter");
//		try{
//		CompanyDetails com =  new CompanyDetails();
//		com.setCompanyName(sanitizeData.sanitizeString(request.getParameter("companyName")));
//		com.setCity(sanitizeData.sanitizeString(request.getParameter("city")));
//		com.setState(sanitizeData.sanitizeString(request.getParameter("state")));
//		com.setCountry(sanitizeData.sanitizeString(request.getParameter("country")));
//		com.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
//		
//		CompanyDetails company = companyDao.addNewCompany(com);
//		
//		Recruiter recruiter = new Recruiter();
//		
//		recruiter.setUsername(sanitizeData.sanitizeString(request.getParameter("username")));
//		recruiter.setPassword(sanitizeData.sanitizePassword(request.getParameter("password")));
//		System.out.println("before encryption :"+ recruiter.getPassword());
//		recruiter.setPassword(Encryption.encrypt(recruiter.getPassword()));
//		System.out.println("after encryption :" + recruiter.getPassword());
//		recruiter.setUserType(request.getParameter("userType"));
//		recruiter.setUserStatus("active");
//		recruiter.setFirstName(sanitizeData.sanitizeString(request.getParameter("firstName")));
//		recruiter.setLastName(sanitizeData.sanitizeString(request.getParameter("lastName")));
//		recruiter.setDesignation(sanitizeData.sanitizeString(request.getParameter("designation")));
//		recruiter.setEmailId(sanitizeData.sanitizeEmail(request.getParameter("emailId")));
//		recruiter.setPhoneNumber(sanitizeData.sanitizeString(request.getParameter("phoneNumber")));
//		
//		recruiter.setCompanyDetails(com);
//		
//		company.getRecruiters().add(recruiter);
//		
//		Recruiter r = recruiterDao.registerRecruiter(recruiter);
//		String message = "Welcome, Sign-up successful for" + recruiter.getFirstName() + " " + recruiter.getLastName() +
//				". Your Username is '" + recruiter.getUsername() +"'.";
//		String subject = "Sign Up successful.";
//		String recipient = recruiter.getEmailId();
//		sendEmail.sendEmail(mailSender, recipient, subject, message);
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("recruiter", r);
//		ModelAndView model = new ModelAndView("recruiter-homepage");
//		return model;
//		}catch(UserException e){
//			System.out.println("Exception: " + e.getMessage());
//			return new ModelAndView("error", "errorMessage", "Username already exists");
//		}
//		catch(Exception e){
//			System.out.println("Exception: " + e.getMessage());
//			return new ModelAndView("error", "errorMessage", "Error while registering recruiter");
//		}
//	}
	
	@RequestMapping(value = "registerRecruiter.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewRecruiter(HttpServletRequest request, @ModelAttribute("recruiter") Recruiter recruiter, BindingResult result) {
		System.out.println("inside registerNewRecruiter");
		
		recruiterValidator.validate(recruiter, result);
		
		if (result.hasErrors()) {
			return new ModelAndView("register-recruiter", "recruiter", recruiter);
		}
		try{
		CompanyDetails com =  new CompanyDetails();
		com = recruiter.getCompanyDetails();
		com.setCompanyName(sanitizeData.sanitizeString(com.getCompanyName()));
		com.setCity(sanitizeData.sanitizeString(com.getCity()));
		com.setState(sanitizeData.sanitizeString(com.getState()));
		com.setCountry(sanitizeData.sanitizeString(com.getCountry()));
		com.setZipCode((com.getZipCode()));
		
		CompanyDetails company = companyDao.addNewCompany(com);

		recruiter.setUsername(sanitizeData.sanitizeString(recruiter.getUsername()));
		recruiter.setPassword(sanitizeData.sanitizePassword(recruiter.getPassword()));
		System.out.println("before encryption :"+ recruiter.getPassword());
		recruiter.setPassword(Encryption.encrypt(recruiter.getPassword()));
		System.out.println("after encryption :" + recruiter.getPassword());
		recruiter.setUserType(recruiter.getUserType());
		recruiter.setUserStatus("active");
		recruiter.setFirstName(sanitizeData.sanitizeString(recruiter.getFirstName()));
		recruiter.setLastName(sanitizeData.sanitizeString(recruiter.getLastName()));
		recruiter.setDesignation(sanitizeData.sanitizeString(recruiter.getDesignation()));
		recruiter.setEmailId(sanitizeData.sanitizeEmail(recruiter.getEmailId()));
		recruiter.setPhoneNumber(sanitizeData.sanitizeString(recruiter.getPhoneNumber()));
		
		recruiter.setCompanyDetails(com);
		
		company.getRecruiters().add(recruiter);
		
		Recruiter r = recruiterDao.registerRecruiter(recruiter);
		String message = "Welcome, Sign-up successful for '" + recruiter.getFirstName() + " " + recruiter.getLastName() +
				"'. Your Username is '" + recruiter.getUsername() +"'.";
		String subject = "Sign Up successful.";
		String recipient = recruiter.getEmailId();
		sendEmail.sendEmail(mailSender, recipient, subject, message);
		
		HttpSession session = request.getSession();
		session.setAttribute("recruiter", r);
		ModelAndView model = new ModelAndView("recruiter-homepage");
		return model;
		}catch(UserException e){
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Username already exists");
		}
		catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Error while registering recruiter");
		}
	}
	
	public boolean checkRecSession(HttpSession session){
		Recruiter c = (Recruiter) session.getAttribute("recruiter");
		if (c == null){
			return false; 
		}else{
			return true;
		}
	}

}

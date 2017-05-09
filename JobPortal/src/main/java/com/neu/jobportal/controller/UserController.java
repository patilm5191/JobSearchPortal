package com.neu.jobportal.controller;

import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.Cookie;
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

import com.neu.jobportal.exception.JobException;
import com.neu.jobportal.exception.UserException;
import com.neu.jobportal.dao.RecruiterDAO;
import com.neu.jobportal.dao.UserDAO;
import com.neu.jobportal.pojo.ApplicationStatus;
import com.neu.jobportal.pojo.Candidate;
import com.neu.jobportal.pojo.Recruiter;
import com.neu.jobportal.pojo.User;
import com.neu.jobportal.utils.Encryption;
import com.neu.jobportal.utils.SendEmail;
import com.neu.jobportal.pojo.JobDetails;
import com.neu.jobportal.validator.CandidateValidator;
import com.neu.jobportal.validator.UserValidator;
import com.neu.jobportal.validator.SanitizeData;


@Controller
//@RequestMapping("/candidate/*")
public class UserController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("recruiterDao")
	RecruiterDAO recruiterDao;
	
	@Autowired
	@Qualifier("sanitizeData")
	SanitizeData sanitizeData;
	
	@Autowired
	@Qualifier("candidateValidator")
	CandidateValidator validator;
	
	@Autowired
	@Qualifier("sendEmail")
	SendEmail sendEmail;
	
	@Autowired
	JavaMailSender mailSender;
//	
//	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(value="index.htm", method= RequestMethod.GET)
	public String showHomePage(){
		
		return "homepage";
	}
	
	@RequestMapping(value="userlogin.htm", method= RequestMethod.GET)
	public String displayHomePage(){
		
		return "homepage";
	}
	
	@RequestMapping(value="userlogin.htm", method= RequestMethod.POST)
	public ModelAndView validateLogin(HttpServletRequest request){
		System.out.println("inside validateLogin");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		username = sanitizeData.sanitizeString(username);
		System.out.println("UserName : " + username);
		password = sanitizeData.sanitizePassword(password);
		System.out.println("Password : " + password);
		password = Encryption.encrypt(password);
		System.out.println("after encryption : " + password);
		HttpSession session = request.getSession();
		
		try{
			User user = userDao.validateLogin(username, password);
			if(user == null)
			{
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			}else if(!(user.getUserStatus().equals("active"))){
				System.out.println("User is Disabled/Deleted");
				session.setAttribute("errorMessage", "User must be Disabled/Deleted");
				return new ModelAndView("error");
			}
		
			if(user.getUserType().equals("candidate"))
			{
				session.setAttribute("user", user);
				Candidate candidate = new Candidate();
				candidate = userDao.getCandidateDetails(user);
//				Cookie ck =  new Cookie("user",candidate.getUsername());
//				
				ModelAndView  model = new ModelAndView("candidate-homepage");
//				model.addObject("ck",ck);
				session.setAttribute("candidate", candidate);
				return model;
				}
			else if(user.getUserType().equals("recruiter"))
			{
				session.setAttribute("user",user);
				Recruiter recruiter = new Recruiter();
				recruiter =  recruiterDao.getRecruiter(user);
				session.setAttribute("recruiter", recruiter);
				return new ModelAndView("recruiter-homepage");
			}
		}
		catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			 return new ModelAndView("error");
		}
		return new ModelAndView("homepage");
}
		
	
	
	@RequestMapping(value = "logout.htm" , method = RequestMethod.GET)
	protected String logoutUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "homepage";
	}
	
	@RequestMapping(value = "registerCandidate.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser() throws Exception {
		System.out.print("registerCandidate");

		return new ModelAndView("register-candidate", "candidate", new Candidate());
	}
		
	@RequestMapping(value = "registerCandidate.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("candidate") Candidate candidate, BindingResult result) {
		System.out.println("inside registerCandidate");
	
		validator.validate(candidate, result);

		if (result.hasErrors()) {
			return new ModelAndView("register-candidate", "candidate", candidate);
		}
	//	UserDAO userDao = new UserDAO();
		
//		User user = new User();
//		user.setUsername(request.getParameter("username"));
//		user.setPassword(request.getParameter("password"));
//		user.setUserType(request.getParameter("userType"));
//		user.setUserStatus("active");
//		
//		User u = userDao.registerCandidate(user);
//		Candidate candidate = new Candidate();
//		candidate.setFirstName(request.getParameter("firstName"));
//		candidate.setLastName(request.getParameter("lastName"));
//		candidate.setUsername(request.getParameter("username"));
//		candidate.setPassword(request.getParameter("password"));
//		candidate.setUserType(request.getParameter("userType"));
		
		candidate.setUsername(sanitizeData.sanitizeString(candidate.getUsername()));
		candidate.setPassword(sanitizeData.sanitizePassword(candidate.getPassword()));
		candidate.setPassword(Encryption.encrypt(candidate.getPassword()));
		candidate.setFirstName(sanitizeData.sanitizeString(candidate.getFirstName()));
		candidate.setLastName(sanitizeData.sanitizeString(candidate.getLastName()));
		candidate.setCity(sanitizeData.sanitizeString(candidate.getCity()));
		candidate.setState(sanitizeData.sanitizeString(candidate.getState()));
		candidate.setCountry(sanitizeData.sanitizeString(candidate.getCountry()));
		candidate.setEmailId(sanitizeData.sanitizeEmail(candidate.getEmailId()));
		System.out.println("candidate email :" + candidate.getEmailId());
		System.out.println("candidate firstname :" + candidate.getFirstName());
		
		HttpSession session = request.getSession();
		try{
			candidate.setUserStatus("active");
			Candidate c = userDao.registerCandidate(candidate);
			String message = "Welcome, Sign-up successful for " + candidate.getFirstName() + " " + candidate.getLastName() +
					". Your Username is '" + candidate.getUsername() +"'.";
			String subject = "Sign Up successful.";
			String recipient = candidate.getEmailId();
			sendEmail.sendEmail(mailSender, recipient, subject, message);
			session.setAttribute("candidate", candidate);
			return new ModelAndView("candidate-homepage");
		}
		catch(MessagingException e){
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Email send failed");
		}
		catch(UserException e){
			System.out.println("User Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "Username already exists");
		}
	}
	
	@RequestMapping(value = "goToCandidateHomePage.htm", method = RequestMethod.GET)
	protected String goToCandidateHomePage(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkUserSession(session);
		if(flag == true){
			return "candidate-homepage";
		}else{
			return "homepage";
		}
	}
	
	@RequestMapping(value = "updateCandidatedetails.htm", method = RequestMethod.GET)
	protected ModelAndView updateCandidateProfile(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkUserSession(session);
		if(flag == true){
			Candidate c = (Candidate)session.getAttribute("candidate");
			long candidateId = c.getUserId();
			c = userDao.getCandidateById(candidateId);
			return new ModelAndView("updateCandidateProfile","c",c);
		}else{
			return new ModelAndView("homepage");
		} 
	}
	

	@RequestMapping(value = "updateCandidatedetails.htm", method = RequestMethod.POST)
	protected ModelAndView updateCandidateProfile(HttpServletRequest request, @ModelAttribute("c") Candidate c){
		HttpSession session = request.getSession();
		boolean flag = checkUserSession(session);
		if(flag == true){
			try{
			userDao.updateCandidate(c);
			return new ModelAndView("candidate-homepage");
			}
			catch(UserException e){
				System.out.println("User Exception: " + e.getMessage());
				return new ModelAndView("error", "errorMessage", "Username already exists");
			}
		}else{
			return new ModelAndView("homepage");
		}
	}
	
	public boolean checkUserSession(HttpSession session){
		Candidate c = (Candidate) session.getAttribute("candidate");
		if (c == null){
			return false; 
		}else{
			return true;
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

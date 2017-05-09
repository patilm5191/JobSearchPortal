package com.neu.jobportal.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.jobportal.dao.JobDAO;
import com.neu.jobportal.dao.RecruiterDAO;
import com.neu.jobportal.dao.UserDAO;
import com.neu.jobportal.exception.JobException;
import com.neu.jobportal.exception.UserException;
import com.neu.jobportal.pojo.ApplicationStatus;
import com.neu.jobportal.pojo.Candidate;
import com.neu.jobportal.pojo.JobDetails;
import com.neu.jobportal.pojo.Recruiter;
import com.neu.jobportal.validator.JobValidator;
import com.neu.jobportal.validator.SanitizeData;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JobController {
	
	@Autowired
	@Qualifier("jobDao")
	JobDAO jobDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	@Qualifier("jobValidator")
	JobValidator validator;
	
	@Autowired
	@Qualifier("sanitizeData")
	SanitizeData sanitizeData;
	
	@InitBinder("jobDetails")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@Autowired
	ServletContext servletContext;
	
//	@RequestMapping(value = "postnewjob.htm", method = RequestMethod.GET)
//	protected ModelAndView postNewJob() throws Exception {
//		System.out.print("Inside postNewJob()");
//
//		return new ModelAndView("add-job");
//	}

//	@RequestMapping(value = "postnewjob.htm", method = RequestMethod.POST)
//	protected ModelAndView addNewJob(HttpServletRequest request){
//		System.out.println("inside addNewJob");
//		HttpSession session = request.getSession();
//		boolean flag = checkRecSession(session);
//		if (flag == true)
//		{
//			try{
//			Recruiter recruiter = new Recruiter();
//			recruiter = (Recruiter)session.getAttribute("recruiter");
//			System.out.println("recruiterId" + recruiter.getUserId());
//			
//			JobDetails jobDetails = new JobDetails();
//			jobDetails.setJobTitle(request.getParameter("jobTitle"));
//			jobDetails.setJobType(request.getParameter("jobType"));
//			jobDetails.setIndustry(request.getParameter("industry"));
//			jobDetails.setJobDescription(request.getParameter("jobDescription"));
//			jobDetails.setNumberOfOpenings(Integer.parseInt(request.getParameter("numberOfOpenings")));
//			jobDetails.setCompensation(Integer.parseInt(request.getParameter("compensation")));
//			jobDetails.setBonusAmount(Integer.parseInt(request.getParameter("bonusAmount")));
//			jobDetails.setRecruiter(recruiter);
//
//			jobDao.postNewJob(jobDetails);
//			return new ModelAndView("recruiter-homepage","message","Job Posted successfully");
//			}
//			catch(JobException e){
//				System.out.println("Exception: " + e.getMessage());
//				return new ModelAndView("error", "errorMessage", "New Job Posting Fail");
//			}	
//		}
//		else
//		{
//			return new ModelAndView("homepage");
//		}
//	}
//	
	
	@RequestMapping(value = "postnewjob.htm", method = RequestMethod.GET)
	protected ModelAndView postNewJob(HttpServletRequest request) throws Exception {
		System.out.print("Inside postNewJob()");
		HttpSession session = request.getSession();
		boolean flag = checkRecSession(session);
		if (flag == true)
		{
			return new ModelAndView("add-job","jobPost", new JobDetails());
		}
		else{
			return new ModelAndView("homepage");
		}
		
	}
	
	@RequestMapping(value = "postnewjob.htm", method = RequestMethod.POST)
	protected ModelAndView addNewJob(HttpServletRequest request, @ModelAttribute("jobPost") JobDetails jobDetails, BindingResult result){
		System.out.println("inside addNewJob");
		HttpSession session = request.getSession();
		boolean flag = checkRecSession(session);
		if (flag == true)
		{
			try{
			Recruiter recruiter = new Recruiter();
			recruiter = (Recruiter)session.getAttribute("recruiter");
			System.out.println("recruiterId" + recruiter.getUserId());
			validator.validate(jobDetails, result);
			if (result.hasErrors()) {
				return new ModelAndView("add-job", "jobPost", jobDetails);
			}
		//	JobDetails jobDetails = new JobDetails();
//			jobDetails.setJobTitle(request.getParameter("jobTitle"));
//			jobDetails.setJobType(request.getParameter("jobType"));
//			jobDetails.setIndustry(request.getParameter("industry"));
//			jobDetails.setJobDescription(request.getParameter("jobDescription"));
//			jobDetails.setNumberOfOpenings(Integer.parseInt(request.getParameter("numberOfOpenings")));
//			jobDetails.setCompensation(Integer.parseInt(request.getParameter("compensation")));
//			jobDetails.setBonusAmount(Integer.parseInt(request.getParameter("bonusAmount")));
			jobDetails.setStatus("active");
			jobDetails.setRecruiter(recruiter);

			jobDao.postNewJob(jobDetails);
			return new ModelAndView("recruiter-homepage","message","Job Posted successfully");
			}
			catch(JobException e){
				System.out.println("Exception: " + e.getMessage());
				return new ModelAndView("error", "errorMessage", "New Job Posting Fail");
			}	
		}
		else
		{
			return new ModelAndView("homepage");
		}
	}
	
	
	
	@RequestMapping(value = "viewpostedjobs.htm", method = RequestMethod.GET)
	protected ModelAndView viewPostedJobs(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkRecSession(session);
		if (flag == true)
		{
			Recruiter recruiter = (Recruiter) session.getAttribute("recruiter");
			System.out.println("recruiter ID "  + recruiter.getUserId());
			ArrayList<JobDetails> postedJobs = new ArrayList<JobDetails>();
			
			postedJobs = jobDao.getPostedJobs(recruiter);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("postedJobs", postedJobs);
			mv.setViewName("posted-jobs");
			return mv;
		}
		else{
			return new ModelAndView("homepage");
		}
	}
	
	@RequestMapping(value = "searchJob.htm", method = RequestMethod.POST)
	protected ModelAndView searchJobs(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkUserSession(session);
		if(flag == true){
			String jobTitle = sanitizeData.sanitizeString(request.getParameter("searchJobTitle"));
			System.out.println("jobTitle " + jobTitle);
			ArrayList<JobDetails> jobList = new ArrayList<JobDetails>();
			
			jobList = jobDao.getJobList(jobTitle);
			for (JobDetails job : jobList){
				System.out.println(job.getJobTitle());
			}
			session.setAttribute("jobSearchTitle", jobTitle);
			ModelAndView model = new ModelAndView();
			model.addObject("jobList", jobList);
			model.setViewName("show-joblist");
			return model;
		}else{
			return new ModelAndView("homepage");
		}
	}
	
	@RequestMapping(value = "applyForJob.htm", method = RequestMethod.GET)
	protected ModelAndView applyJob(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkUserSession(session);
		if(flag == true){
			long jobId = Long.parseLong(request.getParameter("jobid"));
			JobDetails jobDetail = jobDao.getJobDetail(jobId);
			System.out.println("Job Id : " + jobDetail.getJobId());
			System.out.println("Job Title : " + jobDetail.getJobTitle());
		//	ApplicationStatus submitApplication = new ApplicationStatus();
		//	submitApplication.setJob(jobDetail);
			ModelAndView model = new ModelAndView("applyJob");
			model.addObject("job", jobDetail);
			model.addObject("submitApplication", null);
			return model;
		}else{
			return new ModelAndView("homepage");
		}
		
	}
	
	@RequestMapping(value = "applyForJob.htm", method = RequestMethod.POST)
	protected ModelAndView submitApplication(HttpServletRequest request, @ModelAttribute("submitApplication") ApplicationStatus submitApplication) 
			throws UserException, IllegalStateException, IOException{
		try{
			//String name = request.getParameter("filename");
		//	System.out.println("name" + name);
	//		submitApplication.setFilename(name);
	//		System.out.println("filename : " + submitApplication.getFilename());
			//if(submitApplication.getFilename().trim() != "" || submitApplication.getFilename() != null)
			
			HttpSession session = request.getSession();
			Candidate candidate = (Candidate)session.getAttribute("candidate");
			long jobId = Long.parseLong(request.getParameter("jobid"));
			System.out.println("Job Id : " + jobId);
			System.out.println("Candiate Id :" + candidate.getUserId());
	
//			String filename = request.getParameter("filename");
			
			
			File directory;
			String check = File.separator;
			String path = null;
			
			if (check.equalsIgnoreCase("\\")) {
				path = servletContext.getRealPath("").replace("build\\", "");
			}
			if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					path += "/"; // Adding trailing slash for Mac systems.
			}
			
			System.out.println("path : " + path);
			System.out.println("FileName : " + candidate.getUsername());	
			directory = new File(path + "\\" + candidate.getUsername());
			System.out.println("directory : " + directory);
			boolean temp = directory.exists();
			if (!temp) {
				temp = directory.mkdir();
			}
			
			if(temp){
				CommonsMultipartFile resume = submitApplication.getResume();
				String fileName = resume.getOriginalFilename();
				System.out.println("filename :" + fileName );
				
				File localFile = new File(directory.getPath(), fileName);
				resume.transferTo(localFile);
				submitApplication.setFilename(localFile.getPath());
				System.out.println("Resume is stored at" + localFile.getPath());
			} else {
				System.out.println("Failed to create directory!");
			}
			
			JobDetails job = jobDao.getJobDetail(jobId);
			System.out.println("Job Title : " + job.getJobTitle());
			job.getAppliedJobs().add(submitApplication);
			candidate.getAppliedJobs().add(submitApplication);
			submitApplication.setStatus("Applied");
			submitApplication.setCandidate(candidate);
			submitApplication.setJob(job);
			
			userDao.updateCandidate(candidate);
			jobDao.updateJob(job);
			jobDao.submitApplication(submitApplication);
			return new ModelAndView("success-page","job",job);
//			}
//			else {
//				return new ModelAndView("error","message","Error while submitting application");
//			}
		}
		catch(UserException e){
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while updating Candidate");
		}catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while updating Candidate");
		}
	}
	
//	page : Check Application Status 
	
	@RequestMapping(value = "viewAppliedJobs", method = RequestMethod.GET)
	protected ModelAndView viewAppliedJobsForCandidate(HttpServletRequest request){
		HttpSession session = request.getSession();
		boolean flag = checkUserSession(session);
		if(flag == true){
			Candidate c = (Candidate)session.getAttribute("candidate");
			ArrayList<ApplicationStatus> appliedJobs = new ArrayList<ApplicationStatus>();
			appliedJobs = jobDao.getAppliedJobsByCandidate(c);
			ModelAndView model = new ModelAndView();
			model.addObject("appliedJobs", appliedJobs);
			model.setViewName("viewAppliedJobs");
			return model;
		}
		else{
			return new ModelAndView("homepage");
		}
	}
	
	@RequestMapping(value = "changeStatus", method = RequestMethod.GET)
	protected ModelAndView updateApplicationStatus(HttpServletRequest request){
		HttpSession session = request.getSession();
		System.out.println("id " + Long.parseLong(request.getParameter("id")) );
		long jobId = Long.parseLong(request.getParameter("id"));
		ArrayList<ApplicationStatus> jobs = new ArrayList<ApplicationStatus>();
		jobs = jobDao.getAppliedJobsById(jobId);
		System.out.println("inside update " + jobs.size());
		ModelAndView model = new ModelAndView();
		model.addObject("jobs", jobs);
		model.setViewName("changeApplicationStatus");
		return model;
	}
	
	@RequestMapping(value = "updateAppStatus", method = RequestMethod.POST)
	protected ModelAndView updateAppStatus(HttpServletRequest request){
		long appId = Long.parseLong(request.getParameter("appId"));
		long jobId = Long.parseLong(request.getParameter("jobId"));
		String status = request.getParameter("status");
		boolean iReturn = jobDao.updateApp(appId, status);
		if (iReturn == false){
			System.out.println("Application Status not updated");
			return null;
		}
		else{
			System.out.println("Application Status updated successfully");
			ArrayList<ApplicationStatus> jobs = new ArrayList<ApplicationStatus>();
			jobs = jobDao.getAppliedJobsById(jobId);
			System.out.println("inside update app" + jobs.size());
			ModelAndView model = new ModelAndView();
			model.addObject("jobs", jobs);
			model.setViewName("changeApplicationStatus");
			return model;
		}
	}
	
	@RequestMapping(value = "updateJobStatus.htm", method = RequestMethod.POST)
	public void updateJobStatus(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("i am in updateJobStatus");
	//	response.setContentType("text/html;charset=UTF-8");
		long jobId = Long.parseLong(request.getParameter("jobId"));
		System.out.println("inside updateJobStatus");
		System.out.println("jobId : "+ jobId);
		String status = "disable";
		jobDao.updateStatus(jobId,status);
		PrintWriter out = response.getWriter();
		out.println("disable");
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

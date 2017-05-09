package com.neu.jobportal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.jobportal.dao.JobDAO;
import com.neu.jobportal.dao.UserDAO;

@Controller
public class UpdateController {
	
	@Autowired
	@Qualifier("jobDao")
	JobDAO jobDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
//	@RequestMapping(value = "updateJobStatus.htm", method = RequestMethod.POST)
//	public void updateJobStatus(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		response.setContentType("text/html;charset=UTF-8");
//		long jobId = Long.parseLong(request.getParameter("jobId"));
//		System.out.println("inside updateJobStatus");
//		System.out.println("jobId : "+ jobId);
//		String status = "disable";
//		jobDao.updateStatus(jobId,status);
//		PrintWriter out = response.getWriter();
//		out.println("Disabled");
//	}
}

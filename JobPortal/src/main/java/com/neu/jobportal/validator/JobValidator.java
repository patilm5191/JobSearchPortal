package com.neu.jobportal.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.jobportal.pojo.JobDetails;

public class JobValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(JobDetails.class);
	}

	public void validate(Object obj, Errors errors) {
		JobDetails job = (JobDetails) obj;
		
		System.out.println("inside candidate Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "error.invalid.job", "Job Title is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobType", "error.invalid.job", "job Type is  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "industry", "error.invalid.job", "Company Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobDescription", "error.invalid.job", "Job Description is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfOpenings", "error.invalid.job","No of Openings is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "compensation", "error.invalid.job", "Compensation is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bonusAmount", "error.invalid.job", "Bonus Amount is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.job", "State is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.job", "Country is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "error.invalid.job","Zipcode is Required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userType", "error.invalid.candidate","Please select Account Type");
	}
}

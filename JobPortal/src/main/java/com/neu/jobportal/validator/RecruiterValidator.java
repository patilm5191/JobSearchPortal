package com.neu.jobportal.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.jobportal.pojo.Recruiter;

public class RecruiterValidator implements Validator{
	
	public boolean supports(Class aClass) {
		return aClass.equals(Recruiter.class);
	}

	public void validate(Object obj, Errors errors) {
		Recruiter recruiter = new Recruiter();
		System.out.println("inside recruiter Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.recruiter", "First Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.recruiter", "Last Name is  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.recruiter", "Username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.recruiter", "Password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "designation", "error.invalid.recruiter","Designation is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.email","Email is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.recruiter", "Phone Number is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyDetails.companyName", "error.invalid.companyDetails.companyName", "Company Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyDetails.city", "error.invalid.companyDetails.city", "City is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyDetails.state", "error.invalid.companyDetails.state", "State is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyDetails.country", "error.invalid.companyDetails.country", "State is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyDetails.zipCode", "error.invalid.companyDetails.zipCode","Zipcode is Required");
	}
}

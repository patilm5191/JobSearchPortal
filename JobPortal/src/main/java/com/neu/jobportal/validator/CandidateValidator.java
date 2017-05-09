package com.neu.jobportal.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.jobportal.pojo.Candidate;

public class CandidateValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(Candidate.class);
	}

	public void validate(Object obj, Errors errors) {
		Candidate candidate = (Candidate) obj;
		
		System.out.println("inside candidate Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.candidate", "First Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.candidate", "Last Name is  Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.candidate", "Username is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.candidate", "Password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.candidate","Email is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "error.invalid.candidate", "Phone Number is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.candidate", "City is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.candida te", "State is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "error.invalid.candidate", "Country is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "error.invalid.candidate","Zipcode is Required");
	//	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userType", "error.invalid.candidate","Please select Account Type");
	}
	

	
}

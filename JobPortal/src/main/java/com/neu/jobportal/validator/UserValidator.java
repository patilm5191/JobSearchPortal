package com.neu.jobportal.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.jobportal.pojo.User;

public class UserValidator implements Validator{


		public boolean supports(Class aClass) {
			return aClass.equals(User.class);
		}

		public void validate(Object obj, Errors errors) {
			User candidate = (User) obj;
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.candidate", "First Name Required");
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.candidate", "Last Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.user", "Password Required");
//			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.invalid.candidate","Email Required");
		}
}

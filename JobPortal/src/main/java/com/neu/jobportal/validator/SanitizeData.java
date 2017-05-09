package com.neu.jobportal.validator;

public class SanitizeData {
	
	public String sanitizeString(String s){
	String reg = "[!|@|?|=|&|$|%|^|(|)|~|<|>|#|/|;|:|*|{|}|[|]|.|,]+";
	String s1 = s.replaceAll(reg,"");
	return s1;
	}
	
	public String sanitizeEmail(String s){
	String reg = "[!|?|=|&|$|%|^|(|)|~|<|>|#|/|;|:|*]+";
	String s1 = s.replaceAll(reg,"");
	return s1;
	}
	
	public String sanitizePassword(String s){
//		allow special characters like @,!,#,$ and & in password field
		String reg = "[?|=|%|^|(|)|~|<|>|/|;|:|*]+"; 
		String password = s.replaceAll(reg,"");
		return password;
	}

	public String sanitizeNumber(String s){
		return null;
	}
}


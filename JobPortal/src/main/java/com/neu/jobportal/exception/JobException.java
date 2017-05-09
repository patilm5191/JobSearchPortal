package com.neu.jobportal.exception;

public class JobException extends Exception {

		public JobException(String message)
		{
			super("JobException :"+message);
		}
		
		public JobException(String message, Throwable cause)
		{
			super("JobException-"+message,cause);
		}
	
}

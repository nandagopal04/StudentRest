package com.chs.exception;

public class InvalidStudentIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805574453205244183L;

	public InvalidStudentIdException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidStudentIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidStudentIdException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidStudentIdException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidStudentIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

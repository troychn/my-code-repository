package com.edu.common.dao;

public class DaoException extends Exception {

	private static final long serialVersionUID = 6630109937276480623L;
	
	public DaoException() {
		super();
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}

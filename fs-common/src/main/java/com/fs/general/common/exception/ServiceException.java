package com.fs.general.common.exception;

import org.slf4j.Logger;


/**
 * @author fangl
 *
 */
public class ServiceException extends AbstractException {

	/**  */
    private static final long serialVersionUID = -7458153543156179397L;


	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @param message
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(Exception e,Logger log) {
		super( e, log);
	}

}

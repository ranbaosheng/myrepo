package com.fs.general.common.exception;


/**
 * 新增的用户已经存在
 *
 */
public class UserExistException extends AbstractException {

	/**  */
    private static final long serialVersionUID = -7458153543156179397L;


	/**
	 * @param cause
	 */
	public UserExistException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public UserExistException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @param message
	 */
	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

}

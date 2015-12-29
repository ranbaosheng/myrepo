package com.fs.general.common.exception;


/**
 * 用户输入的旧密码不对
 *
 */
public class UserOldPwdErrorException extends AbstractException {

	/**  */
    private static final long serialVersionUID = -7458153543156179397L;


	/**
	 * @param cause
	 */
	public UserOldPwdErrorException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public UserOldPwdErrorException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @param message
	 */
	public UserOldPwdErrorException(String message, Throwable cause) {
		super(message, cause);
	}

}

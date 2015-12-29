package com.fs.general.common.exception;

/**
 * @author YANGZHONGLI
 *
 */
public class DaoException extends AbstractException {

	/**  */
    private static final long serialVersionUID = -7458153543156179397L;


	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 * @param message
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}

package com.fs.general.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.slf4j.Logger;


/**
 * 异常的抽象公共类
 * 
 * @author echo
 * 
 */
public abstract class AbstractException extends Exception {
	/**  */
	private static final long serialVersionUID = -6027552425848468933L;

	protected Throwable cause;

	private String message;

	/**
	 * @param cause
	 */
	public AbstractException(Throwable cause) {
		super(cause);
		message = (cause == null ? null : cause.toString());
		this.cause = cause;
	}

	/**
	 * @param message
	 */
	public AbstractException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * @param cause
	 * @param message
	 */
	public AbstractException(String message, Throwable cause) {
		super(message, cause);
		message = (cause == null ? null : cause.toString());
		this.cause = cause;
		this.message = message;
	}

	/**
	 * @return the cause
	 */
	public Throwable getCause() {
		return cause;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	@Override
	public void printStackTrace() {
		printStackTrace(System.err);
	}

	@Override
	public void printStackTrace(PrintStream outStream) {
		printStackTrace(new PrintWriter(outStream));
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);

		if (this.getCause() != null) {
			this.getCause().printStackTrace(s);
		}
		s.flush();
	}
	
	public AbstractException(Exception e,Logger log)
	{
		super(e);
		
		//把堆栈信息记录到日志
		StackTraceElement[] ste = e.getStackTrace();
		StringBuffer sb = new StringBuffer();
		sb.append(e.getMessage() + "\r\n");
		for (int i = 0;i < ste.length;i++)
		{
			sb.append(ste[i].toString() + "\r\n");
		}
		log.error(sb.toString());
	}
}
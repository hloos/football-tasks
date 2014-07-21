package com.footballradar.tasks.technical.exception;


/**
 * Technical exception.
 * @author hloos
 */
public class TechnicalException extends Exception {

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = -6462579226181080028L;

	public TechnicalException() {
		super("An technical error occured.");
	}
	
	public TechnicalException(String message) {
		super(message);
	}

	public TechnicalException(String message, Throwable cause) {
		super(message, cause);
	}

	public TechnicalException(Throwable cause) {
		super(cause);
	}
}

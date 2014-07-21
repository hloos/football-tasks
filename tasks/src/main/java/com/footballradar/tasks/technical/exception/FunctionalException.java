package com.footballradar.tasks.technical.exception;

/**
* Functional exception.
* @author hloos
*/
public class FunctionalException extends Exception {

	/**
	 * SerialUID.
	 */
	private static final long serialVersionUID = -6462579226181080028L;

	public FunctionalException() {
		super("An Functional error occured.");
	}
	
	public FunctionalException(String message) {
		super(message);
	}

	public FunctionalException(String message, Throwable cause) {
		super(message, cause);
	}

	public FunctionalException(Throwable cause) {
		super(cause);
	}
}


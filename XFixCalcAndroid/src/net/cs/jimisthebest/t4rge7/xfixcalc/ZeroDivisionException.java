package net.cs.jimisthebest.t4rge7.xfixcalc;

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class ZeroDivisionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -291212866789242070L;
	/**
	 * Creates a new ZeroDivisionException with the default message
	 */
	public ZeroDivisionException() {
		super("Error: Division by Zero");
	}
	/**
	 * Creates a new ZeroDivisionException with the desired message
	 * @param message The message to use
	 */
	public ZeroDivisionException(String message) {
		super(message);
	}

}

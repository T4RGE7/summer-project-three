package net.cs.jimisthebest.t4rge7.xfixcalc;

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class OperandsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4518820558771744534L;
	/**
	 * Creates a new OperandsException with the default message
	 */
	public OperandsException() {
		super("Error: Too Many Operands");
	}
	/**
	 * Creates a new OperandsException with the desired message
	 * @param message The message to use
	 */
	public OperandsException(String message) {
		super(message);
	}

}

package net.cs.jimisthebest.t4rge7.xfixcalc;

public class OperandsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4518820558771744534L;

	public OperandsException() {
		super("Error: Too Many Operands");
	}
	
	public OperandsException(String message) {
		super(message);
	}

}

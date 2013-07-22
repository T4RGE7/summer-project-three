package net.cs.jimisthebest.t4rge7.xfixcalc;

public class OperationsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3019041704845235545L;

	public OperationsException() {
		super("Error: Too Many Operations");
	}
	
	public OperationsException(String message) {
		super(message);
	}

}

package net.cs.jimisthebest.t4rge7.xfixcalc;

public class OperandsException extends Exception {

	public OperandsException() {
		super("Error: Too Many Operands");
	}
	
	public OperandsException(String message) {
		super(message);
	}

}
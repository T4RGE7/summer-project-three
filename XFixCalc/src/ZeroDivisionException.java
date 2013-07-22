

public class ZeroDivisionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -291212866789242070L;

	public ZeroDivisionException() {
		super("Error: Division by Zero");
	}
	
	public ZeroDivisionException(String message) {
		super(message);
	}

}

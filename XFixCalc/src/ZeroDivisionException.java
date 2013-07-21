
public class ZeroDivisionException extends Exception {

	public ZeroDivisionException() {
		super("Error: Division by Zero");
	}
	
	public ZeroDivisionException(String message) {
		super(message);
	}

}

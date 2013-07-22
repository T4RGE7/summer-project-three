

/**
 * 
 * @author James Roberts jpr242
 *
 */
public class IllegalInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9194966850065889238L;

	/**
	 * Creates a new IllegalInputException with the default message
	 */
	public IllegalInputException() {
		super("ERROR: Invalid input");
	}
	/**
	 * Creates a new IllegalInputException with the given message
	 * @param message The message to use
	 */
	public IllegalInputException(String message) {
		super(message);
	}
}

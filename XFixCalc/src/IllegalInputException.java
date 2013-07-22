
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

	public IllegalInputException() {
		super("ERROR: Invalid input");
	}
	
	public IllegalInputException(String message) {
		super(message);
	}
}

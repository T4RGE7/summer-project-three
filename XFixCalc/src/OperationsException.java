
/**
 * 
 * @author James Roberts jpr242
 *
 */
public class OperationsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3019041704845235545L;

	/**
	 * Creates a new OperationsException with the default message
	 */
	public OperationsException() {
		super("Error: Too Many Operations");
	}
	/**
	 * Creates a new OperationsException with the desired message
	 * @param message The message to use
	 */
	public OperationsException(String message) {
		super(message);
	}

}

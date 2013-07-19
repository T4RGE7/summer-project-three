/**
 * 
 * @author James Roberts jpr242
 *
 */
public class EmptyListException extends Exception {

	public EmptyListException() {
		super("This list is Empty");
	}
	
	public EmptyListException(String message) {
		super(message);
	}
	
}

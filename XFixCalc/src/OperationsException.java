
public class OperationsException extends Exception {

	public OperationsException() {
		super("Error: Too Many Operations");
	}
	
	public OperationsException(String message) {
		super(message);
	}

}

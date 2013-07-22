package net.cs.jimisthebest.t4rge7.xfixcalc;
/**
 * 
 * @author James Roberts jpr242
 *
 */
public class EmptyListException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2843800313498103350L;

	public EmptyListException() {
		super("This list is Empty");
	}
	
	public EmptyListException(String message) {
		super(message);
	}
	
}

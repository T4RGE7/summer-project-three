
/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedStack<T> extends LinkedList<T> implements StackInterface<T> {
	
	/**
	 * Creates a new empty linked stack
	 */
	public LinkedStack() {
		super();
	}
	
	/**
	 * Creates a new linked stack with data as the only entry
	 * @param data the first entry
	 */
	public LinkedStack(T data) {
		super(data);
	}

	/**
	 * Adds given data to the front of this stack
	 * @param data the data to add
	 */
	@Override
	public void push(T data) {
		this.insertFirst(data);
		
	}
	
	/**
	 * Removes and returns the first element of this stack
	 * @return The first element of this stack
	 * @throws EmptyListException
	 */
	@Override
	public T pop() throws EmptyListException {
		return this.removeFirst();
	}

	/**
	 * Returns the first element of this stack
	 * @return The first element of this stack
	 * @throws EmptyListException
	 */
	@Override
	public T top() throws EmptyListException {
		return this.peekFirst();
	}



}

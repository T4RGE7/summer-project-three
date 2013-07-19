/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedStack<T> extends LinkedList<T> implements StackInterface<T> {
	
	public LinkedStack() {
		super();
	}
	
	public LinkedStack(T data) {
		super(data);
	}

	@Override
	public void push(T data) {
		this.insertFirst(data);
		
	}

	@Override
	public T pop() throws EmptyListException {
		return this.removeFirst();
	}

	@Override
	public T top() throws EmptyListException {
		return this.peekFirst();
	}

	@Override
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}

}

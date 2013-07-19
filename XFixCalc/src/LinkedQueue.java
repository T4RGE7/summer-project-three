
public class LinkedQueue<T> extends LinkedList<T> implements QueueInterface<T> {

	public LinkedQueue() {
		super();
	}
	
	public LinkedQueue(T data) {
		super(data);
	}
	
	@Override
	public void add(T data) {
		this.insertLast(data);
		
	}

	@Override
	public T poll() throws EmptyListException {
		return this.removeFirst();
	}

	@Override
	public T front() throws EmptyListException {
		return this.peekFirst();
	}

}

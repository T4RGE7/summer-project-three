/**
 * 
 * @author JamesRoberts jpr242
 *
 * 
 */
public class LinkedStack<T> implements LinkedStackInterface<Object>{

	private LinkedNode<T> head;
	private LinkedNode<T> current;
	
	public LinkedStack() {
		this.head = null;
		this.current = null;
	}
	
	public LinkedStack(T first) {
		LinkedNode<T> temp = new LinkedNode<T>(first);
		this.head = temp;
		this.current = this.head;
	}

	public void push(T element) {
		LinkedNode<T> temp = new LinkedNode<T>(element);
		if(this.isEmpty()) {
			this.head = temp;
		} else {
			temp.setPointer(this.head);
			this.head = temp;
		}
	}
	
	public T pop() throws NullPointerException{
		if(!this.isEmpty()) {
			T toReturn = this.head.getData();
			this.head = this.head.getPointer();
			return toReturn;
		}
		throw new NullPointerException("The Stack Is Empty");
	}

	public T peek() throws NullPointerException{
		if(!this.isEmpty()) {
			return this.head.getData();
		}
		throw new NullPointerException("The Stack Is Empty");
	}

	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}

	public int size() {
		if(this.isEmpty()) {
			return 0;
		}
		this.current = this.head;
		int toReturn = 1;
		for(; this.current.getPointer() != null; this.current = this.current.getPointer(), toReturn++);
		return toReturn;
	}
	
	public boolean contains(T element) {
		if(this.isEmpty()) {
			return false;
		}
		this.current = this.head;
		while(this.current != null) {
			if(this.current.getData() == element) {
				return true;
			}
			this.current = this.current.getPointer();
		}
		return false;
	}
	
	public String toString() {
		if(this.isEmpty()) {
			return null;
		}
		this.current = this.head;
		String toReturn = this.current.getData().toString();
		for(; this.current.getPointer() != null; this.current = this.current.getPointer(), toReturn += this.current.getData().toString());
		return toReturn;
	}

}

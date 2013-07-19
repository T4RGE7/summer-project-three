/**
 * 
 * @author James Roberts jpr242
 *
 */
public class LinkedList<T> {

	protected Node<T> head, tail, current;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.current = null;
		this.size = 0;
	}
	
	public LinkedList(T data) {
		this.head = new Node<T>(data);
		this.tail = this.head;
		this.current = null;
		this.size = 1;
	}
	
	//adds to front
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		this.size++;
		if(this.isEmpty()) {
			this.head = newNode;
			this.tail = this.head;
			return;
		}
		newNode.setFrontPointer(this.head);
//		if(this.head == this.tail) {
//			this.tail = this.head;
//		}
		this.head = newNode;
	}
	
	//adds to front
	public void insertFirst(T data) {
		this.insert(data);
	}
	
	//adds to back
	public void insertLast(T data) {
		if(this.isEmpty()) {
			this.insert(data);
			return;
		}
		this.size++;
		Node<T> newNode = new Node<T>(data);
		this.tail.setFrontPointer(newNode);
		this.tail = newNode;
	}
	
	//adds to location
	public void insert(T data, int location) {
		if(location > this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			this.insert(data);
			return;
		}
		if(location == this.size) {
			this.insertLast(data);
			return;
		}
		Node<T> newNode = new Node<T>(data);
		this.moveCurrentForwards(location - 1);
		newNode.setFrontPointer(this.current.getFrontPointer());
		this.current.setFrontPointer(newNode);
		this.size++;
	}
	
	//removes from front
	public T remove() throws EmptyListException{
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		this.size--;
		if(this.size == 0) {
			this.tail = null;
		}
		T toReturn = this.head.getData();
		this.head = this.head.getFrontPointer();
		return toReturn;
	}
	
	//removes from front
	public T removeFirst() throws EmptyListException {
		return this.remove();
	}
	
	//removes from end
	public T removeLast() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(this.size == 1) {
			return this.remove();
		}
		this.size--;
		T toReturn = this.tail.getData();
		this.moveCurrentForwards(this.size - 1);
		this.current.setFrontPointer(null);
		this.tail = this.current;
		return toReturn;
	}
	
	//removes from location
	public T remove(int location) throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(location >= this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(location == 0) {
			return this.remove();
		}
		if(location == this.size - 1) {
			return this.removeLast();
		}
		this.size--;
		this.moveCurrentForwards(location - 1);
		T toReturn = this.current.getFrontPointer().getData();
		this.current.setFrontPointer(this.current.getFrontPointer().getFrontPointer());
		return toReturn;
	}
	
	//looks at front
	public T peek() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.head.getData();
	}

	//looks at front
	public T peekFirst() throws EmptyListException {
		return this.peek();
	}
	
	//looks at end
	public T peekLast() throws EmptyListException {
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		return this.tail.getData();
	}
	
	//looks at location
	public T peek(int location) throws EmptyListException {
		if(location >= this.size || location < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(this.isEmpty()) {
			throw new EmptyListException();
		}
		if(location == 0) {
			return this.peek();
		}
		if(location == this.size - 1) {
			return this.peekLast();
		}
		this.moveCurrentForwards(location);
		return this.current.getData();
	}
	
	public void clear() {
		this.head = null;
		this.tail = null;
		this.current = null;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.head == null) {
			return true;
		}
		return false;
	}
	
	protected void moveCurrentForwards(int location) {
	//	System.out.println("Forwards");
		this.current = this.head;
		for(int j = 0; j < location && current.getFrontPointer() != null; j++, this.current = this.current.getFrontPointer());
	}
	
}

/**
 * 
 * @author JamesRoberts jpr242
 *
 * 
 */
public class LinkedNode<T>{

	private T data;
	private LinkedNode<T> pointer;
	
	public LinkedNode(T data) {
		this.data = data;
		this.pointer = null;
	}
	
	public LinkedNode() {
		this.data = null;
		this.pointer = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedNode<T> getPointer() {
		return pointer;
	}

	public void setPointer(LinkedNode<T> pointer) {
		this.pointer = pointer;
	}

	public String toString() {
		return this.data.toString();
	}
}

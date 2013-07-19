/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Node<T> {

	protected T data;
	protected Node<T> frontPointer;
	
	public Node() {
		this.data = null;
		this.frontPointer = null;
	}
	
	public Node(T data) {
		this.data = data;
		this.frontPointer = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getFrontPointer() {
		return frontPointer;
	}

	public void setFrontPointer(Node<T> frontPointer) {
		this.frontPointer = frontPointer;
	}
	
}

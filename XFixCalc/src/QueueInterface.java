/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface QueueInterface<T> {
	
	void add(T data);
	T poll() throws EmptyListException;
	T front() throws EmptyListException;
	boolean isEmpty();
	
}

package net.cs.jimisthebest.t4rge7.xfixcalc;
/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface LinkedListInterface<T> {
	
	void insert(T data);
	void insertFirst(T data);
	void insertLast(T data);
	void insert(T data, int location);
	T remove() throws EmptyListException;
	T removeFirst() throws EmptyListException;
	T removeLast() throws EmptyListException;
	T remove(int location) throws EmptyListException;
	T peek() throws EmptyListException;
	T peekFirst() throws EmptyListException;
	T peekLast() throws EmptyListException;
	T peek(int location) throws EmptyListException;
	void clear();
	int size();
	boolean isEmpty();
	
}

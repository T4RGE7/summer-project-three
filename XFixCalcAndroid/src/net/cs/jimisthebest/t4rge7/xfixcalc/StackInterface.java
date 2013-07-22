package net.cs.jimisthebest.t4rge7.xfixcalc;

/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface StackInterface<T> {

	/**
	 * Adds given data to the front of this stack
	 * @param data the data to add
	 */
	void push(T data);
	/**
	 * Removes and returns the first element of this stack
	 * @return The first element of this stack
	 * @throws EmptyListException
	 */
	T pop() throws EmptyListException;
	/**
	 * Returns the first element of this stack
	 * @return The first element of this stack
	 * @throws EmptyListException
	 */
	T top() throws EmptyListException;
	/**
	 * Returns the empty state of this list
	 * @return true if empty, false if not
	 */
	boolean isEmpty();
	
}

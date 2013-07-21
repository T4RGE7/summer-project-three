package net.cs.jimisthebest.t4rge7.xfixcalc;
/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface StackInterface<T> {

	void push(T data);
	T pop() throws EmptyListException;
	T top() throws EmptyListException;
	boolean isEmpty();
	
}

package ds2Stack;

/**
 * This is a generic interface for implementing stack using linkedlist
 * 
 * @param <T>
 *            could be any type of value which the stack will hold
 */
public interface Stack<T> {

	/**
	 * To push element to the stack
	 * @param element
	 * @return
	 */
	public boolean push(T element);

	/**
	 * To pop element from stack
	 * @return popped element
	 */
	public T pop();

	/**
	 * To see the topmost element
	 * @return topmost element
	 */
	public T top();

	/**
	 * To check whether stack is empty
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * To get the stack of elements
	 * @return
	 */
	public T[] getStack();
}
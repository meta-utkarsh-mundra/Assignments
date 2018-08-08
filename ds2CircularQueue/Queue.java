package ds2CircularQueue;

/**
 * This is interface to implement Queue using Array
 */
public interface Queue {

	/**
	 * To add element to queue
	 * @param element
	 * @return true if element is added
	 */
	public boolean add(int element);

	/**
	 * To delete element from queue
	 * @return the deleted element
	 */
	public int delete();

	/**
	 * To check if queue is empty
	 * @return true if empty else false
	 */
	public boolean isEmpty();

	/**
	 * To check if queue is full
	 * @return true if full else false
	 */
	public boolean isFull();
}
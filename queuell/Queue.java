package ds1;

/**
 * This is interface to implement Queue using linkedlist
 */
public interface Queue {
	//this function adds an integer element
	public void add(int element);
	//it deletes an existing element
	public int delete();
	//it checks if a queue is empty.
	public boolean isEmpty();
	//it checks if a queue is full.
	public boolean isFull();
}

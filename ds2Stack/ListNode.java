package ds2Stack;

/**
 * This class is used to create node of ListNode type
 * 
 * @param <T> could be any value which the node will keep
 */
public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode<T> previous;

	// Constructor to initialise ListNode
	public ListNode(T data) {
		this.data = data;
		next = null;
		previous = null;
	}
}
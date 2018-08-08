package ds2Stack;

/**
 * This is a generic class for implementing stack using linkedlist
 * @param <T> could be any type of value which is passed as parameter
 */
public class StackLinkedList<T> implements Stack<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	int size = 0;

	/**
	 * To push value to stack
	 */
	@Override
	public boolean push(T element) {
		ListNode<T> temp = new ListNode<T>(element);
		if (isEmpty()) {
			setHead(temp);
		} else {
			getTail().next = temp;
			temp.previous = getTail();

		}
		setTail(temp);
		size++;
		return true;
	}

	/**
	 * To pop values from stack
	 */
	@Override
	public T pop() {
		T value = null;
		if (!isEmpty()) {
			if (size == 1) {
				value = (T) getTail().data;
				setTail(null);
				setHead(null);
				size--;
				return value;
			} else {
				value = (T) getTail().data;
				setTail(getTail().previous);
				getTail().next = null;
				size--;
				return value;
			}
		}
		return value;
	}

	/**
	 * To check if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if (getHead() == null && getTail() == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To check for top value
	 */
	@Override
	public T top() {
		if (!isEmpty()) {
			return (T) getTail().data;
		}
		return null;
	}

	/**
	 * To get the stack of values
	 */
	@Override
	public T[] getStack() {
		if (!isEmpty()) {
			T[] array = (T[]) new Object[size];
			ListNode<T> temp = getTail();
			int i = 0;
			while (temp != null) {
				array[i] = (T) temp.data;
				i++;
				temp = temp.previous;
			}
			return array;
		} else {
			return null;
		}
	}

	 /*public T peek() {
	 	if(getTail()!= null && getHead()!= null) {
	 		return getTail().data;
	 	} 
	 	return null;
	 }*/

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> getTail() {
		return tail;
	}

	public void setTail(ListNode<T> tail) {
		this.tail = tail;
	}
}
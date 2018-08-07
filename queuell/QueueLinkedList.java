package ds1;

/**
 * This class is used to create node
 */
class QueueNode {
	int value;
	QueueNode link;

	public QueueNode(int value) {
		this.value = value;
	}
}

/**
 * This class performs various functions on queue using linkedlist
 */
public class QueueLinkedList implements Queue {

	QueueNode rear, front;

	public QueueLinkedList() {
		rear = null;
		front = null;
	}

	/**
	 * To add value to list
	 */
	@Override
	public void add(int value) {
		if (value != (int) value)
			throw new AssertionError("The given input value is not integer!!");
		QueueNode queueNode = new QueueNode(value);
		if (isEmpty()) {
			rear = queueNode;
			rear.link = null;
			front = rear;
		} else {
			queueNode.link = rear;
			rear = queueNode;
		}
	}
	/**
	 * To delete value from list
	 */
	@Override
	public int delete() {
		int value = -1;
		if (!isEmpty()) {
			value = front.value;
			QueueNode queueNode = front;
			front = queueNode.link;
			queueNode.link = null;
		} else
			throw new AssertionError("Queue is empty, cannot pop!!");
		return value;

	}

	/**
	 * To check if list is empty
	 */
	@Override
	public boolean isEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	/**
	 * to check if list is full
	 */
	@Override
	public boolean isFull() {
		return false;
	}
}
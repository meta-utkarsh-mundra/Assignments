package simpleQueue;

public class QueueArray implements Queue {
	private int[] array; //this array will store the queue.
	private int rear = -1; //this is where the elements will be added.
	private int front = -1; // this is where the elements will be deleted.
	private int number; //it defines the size of the queue.
   
	/**
	 * @param number will give the number of elements in the list.
	 * this constructor initializes the array.
	 */
	public QueueArray(int number) {
		array = new int[number];
		this.number = number;
	}

	/**
	 * To add element to queue.
	 * @param element will get added in the queue.
	 */
	@Override
	public void add(int element) {
		if (rear + 1 >= number) {
			throw new AssertionError("Queue is full");
		} else if (rear == -1 && front == -1) {
			array[++rear] = element;
			front++;
		} else {
			array[++rear] = element;
		}
	}

	/**
	 * To delete element from queue.
	 * deletion will be done at front.
	 */
	@Override
	public int delete() {

		if (rear < 0 && front < 0) {
			throw new AssertionError("Queue is empty");
		} else if (front == rear) {
			int deletedElement = array[front];
			front = -1;
			rear = -1;
			return deletedElement;
		} else {
			int deletedElement = array[front];
			front++;
			return deletedElement;
		}
	}

	/**
	 * To check if queue is empty or not
	 */
	@Override
	public boolean isEmpty() {
		if (front < 0) {
			return true;
		}
		return false;

	}

	/**
	 * To check if queue is full
	 */
	@Override
	public boolean isFull() {
		if (rear + 1 >= number) {
			return true;
		}
		return false;
	}

	/**
	 * To print values
	 */
	public void display() {
		System.out.print("\nArray = ");
		if (!isEmpty()) {
			for (int i = front; i <= rear; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
}
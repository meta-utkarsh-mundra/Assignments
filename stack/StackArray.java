package stackImplementation;

/**
 * This class performs various functions on stack using array
 */
public class StackArray implements Stack {
	private int array[];// an array to implement stack.
	private int size; // this defines the size of the stack.
	private int top = -1; // top corresponds to the value last added

	/**
	 * @param size defines the size of the array
	 * constructor to initialize the stack.
	 */
	public StackArray(int size) {
		this.size = size;
		array = new int[size];
	}

	/**
	 * To push values to stack
	 * @param value is that value which is being pushed.
	 */
	@Override
	public void push(int value) {
		if (isFull()) {
			throw new AssertionError("Stack overflow");
		} else {
			top = top + 1;
			array[top] = value;
			System.out.println(value + " is pushed into stack");
		}
	}

	/**
	 * To pop values from stack
	 */
	@Override
	public int pop() {
		if (isEmpty()) {
			throw new AssertionError("Stack is empty");
		} else {
			int value;
			value = array[top];
			top = top - 1;
			System.out.println(value + " is popped from stack");
			return value;
		}
	}

	/**
	 * To check if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To check if stack is full
	 */
	@Override
	public boolean isFull() {
		if (top == size - 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To search for top element
	 */
	@Override
	public int peek() {
		if (!isEmpty()) {
			return array[top];
		} else {
			throw new AssertionError("Stack is empty");
		}
	}

	/**
	 * To display the stack elements
	 */
	public void display() {
		System.out.print("\nStack = ");
		for (int i = top; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
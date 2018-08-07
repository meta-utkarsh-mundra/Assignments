
package stackLinkedList;

/**
 * This class is used to create node
 */
class Node {
	int value;
	Node link;

	public Node(int val) {
		value = val;
	}
}

/**
 * This class performs various functions on stack using linkedlist
 *
 */
public class StackLinkedList implements Stack {

	Node top = null;

	/**
	 * To push value to stack
	 */
	@Override
	public void push(int value) {
		if (top == null) {
			top = new Node(value);
			top.link = null;
			System.out.println(value + " is pushed into stack");
		} else {
			Node newNode = new Node(value);
			newNode.link = top;
			top = newNode;
			System.out.println(value + " is pushed into stack");
		}
	}

	/**
	 * To pop values from stack
	 */
	@Override
	public int pop() {
		if (top == null) {
			throw new AssertionError("Stack is empty");
		}
		int value = top.value;
		Node popNode = top;
		top = popNode.link;
		popNode.link = null;
		return value;
	}

	/**
	 * To check if stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To check for top value
	 */
	public int peek() {
		if (!isEmpty()) {
			int value = top.value;
			return value;
		} else {
			throw new AssertionError("Stack is empty");
		}
	}
}
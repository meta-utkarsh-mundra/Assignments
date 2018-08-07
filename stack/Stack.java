package stackImplementation;

/**
 * This is an interface to implement Stack using Array
 */
public interface Stack {
    // this method pushes a value in the stack
	public void push(int number);
    // this method deletes a value from the stack.
	public int pop();
    // this method returns the top element of the stack.
	public int peek();
    // this method checks if the stack is empty.
	public boolean isEmpty();
	// this method checks if the stack is full.
	public boolean isFull();
}

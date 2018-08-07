package stackLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

import stackImplementation.StackArray;

public class TestStackLinkedList {

	StackLinkedList object = new StackLinkedList();

	/**
	 * To test for adding element to stack
	 */
	@Test
	public void testPush() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.peek());
	}

	/**
	 * To test for pop from stack
	 */
	@Test
	public void testPop() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.peek());
		assertEquals(78, object.pop());
		assertEquals(23, object.peek());
	}

	/**
	 * To test for pop when stack is empty
	 */
	@Test(expected = AssertionError.class)
	public void testPopWhenStackIsEmpty() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.pop());
		assertEquals(23, object.pop());
		assertEquals(null, object.pop());
	}

	/**
	 * To test for peek
	 */
	@Test
	public void testPeek() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.peek());
	}

	/**
	 * To test for peek when stack is empty
	 */
	@Test(expected = AssertionError.class)
	public void testPeekWhenStackIsEmpty() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.pop());
		assertEquals(23, object.pop());
		assertEquals(null, object.peek());
	}

	/**
	 * To test for empty stack when it is empty
	 */
	@Test
	public void testEmptyWhenStackIsEmpty() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.pop());
		assertEquals(23, object.pop());
		assertEquals(true, object.isEmpty());
	}

	/**
	 * To test for empty stack when it is not empty
	 */
	@Test
	public void testEmptyWhenStackIsNotEmpty() {
		object.push(23);
		object.push(78);
		assertEquals(78, object.pop());
		assertEquals(false, object.isEmpty());
	}
}

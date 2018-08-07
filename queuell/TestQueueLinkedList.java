package ds1;

import static org.junit.Assert.*;

import org.junit.Test;

import simpleQueue.QueueArray;

public class TestQueueLinkedList {

	QueueLinkedList object = new QueueLinkedList();

	/**
	 * To test for adding element to queue
	 */
	@Test
	public void testAddition() {
		object.add(23);
		object.add(78);
	}

	/**
	 * To test for deletion from queue
	 */
	@Test
	public void testDeletion() {
		object.add(23);
		object.add(78);
		assertEquals(23, object.delete());
	}

	/**
	 * To test for deletion when queue is empty
	 */
	@Test(expected = AssertionError.class)
	public void testDeletionWhenQueueIsEmpty() {
		object.add(23);
		object.add(78);
		assertEquals(78, object.delete());
		assertEquals(78, object.delete());
		assertEquals(null, object.delete());
	}

	/**
	 * To test for queue when it is not full
	 */
	@Test
	public void testWhenQueueIsNotFull() {
		object.add(23);
		assertEquals(false, object.isFull());
	}

	/**
	 * To test for queue when it is empty
	 */
	@Test
	public void testEmptyWhenQueueIsEmpty() {
		assertEquals(true, object.isEmpty());
	}

	/**
	 * To test for queue when it is not empty
	 */
	@Test
	public void testEmptyWhenQueueIsNotEmpty() {
		object.add(23);
		object.add(78);
		assertEquals(false, object.isEmpty());
	}
}
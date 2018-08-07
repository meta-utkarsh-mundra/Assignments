package simpleQueue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestQueueArray {

	QueueArray object = new QueueArray(2);

	/**
	 * To test for adding element to queue
	 */
	@Test
	public void testAddition() {
		object.add(23);
		object.add(78);
	}

	/**
	 * To test for adding element to queue when queue is full
	 */
	@Test(expected = AssertionError.class)
	public void testAdditionOnFullQueue() {
		object.add(23);
		object.add(78);
		object.add(76);
	}

	/**
	 * To test for deletion from queue
	 */
	@Test
	public void testDeletion() {
		object.add(23);
		object.add(78);
		assertEquals(23, object.delete());
		assertEquals(78, object.delete());
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
	 * To test for queue when it is full
	 */
	@Test
	public void testWhenQueueIsFull() {
		object.add(23);
		object.add(78);
		assertEquals(true, object.isFull());
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
		object.add(23);
		object.add(78);
		assertEquals(23, object.delete());
		assertEquals(78, object.delete());
		assertEquals(true, object.isEmpty());
	}

	/**
	 * To test for queue when it is not empty
	 */
	@Test
	public void testEmptyWhenQueueIsNotEmpty() {
		object.add(23);
		object.add(78);
		assertEquals(23, object.delete());
		assertEquals(false, object.isEmpty());
	}
}
package priorityQueue;

public interface priorityQueueInterface {
	    /**
	     * method to add a process in the queue
	     * @param process is the Process object
	     * @return true if added, false otherwise
	     */
		public boolean enqueue(Process process);
		/**
		 * method to remove an element from the queue
		 * @return the removed process
		 */
		public Process dequeue();
		/**
		 * method to check if the queue is empty
		 * @return boolean value
		 */
		public boolean isEmpty();
		/**
		 * method to check if the queue is full
		 * @return boolean value
		 */
		public boolean isFull();
}

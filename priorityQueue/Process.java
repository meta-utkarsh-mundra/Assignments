package priorityQueue;

public class Process {
		final int value;
		final int priority;
		
		//constructor to initialize fields.
		public Process(int value, int priority) {
			
			this.value = value;
			this.priority = priority;
		}
        //returns the respective value. 
		public int getValue() {
			return value;
		}
        //returns respective priority.
		public int getPriority() {
			return priority;
		}

}

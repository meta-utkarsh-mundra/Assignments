package priorityQueue;

public class SettingPriority implements priorityQueueInterface {
	private Process[] queue;
    private int rear, front, maximumSize;
   
    //constructor to define maximum size.
    public SettingPriority(int maximumSize) {
    	this.maximumSize = maximumSize;
        queue = new Process[maximumSize];
        rear = -1;
        front = -1;
	}
    /**
     * method to add a process in the queue
     * @param process is the process object
     * @return true if added, false otherwise
     */
	@Override
	public boolean enqueue(Process process) {
		try
        {
            if(!isFull())
            {
            	if(rear == -1)
                {
                    front++;
                    rear++;
                }
                else
                {
                    rear = (rear + 1) % maximumSize;
                }
            	int position = -1;
            	for(int i = front; i <= (rear - 1) % maximumSize; i++)
            	{
            		if(process.getPriority() > queue[i].getPriority())
            		{
            			position = i;
            			break;
            		}
            	}
            	if(position != -1)
            	{
            		for(int i = (rear - 1) % maximumSize; i >= position; i--)
                	{
                		queue[(i + 1) % maximumSize] = queue[i];
                	}
                	queue[position] = process;
            	}
            	else
            		queue[rear] = process;
                
            }
            else
                throw new AssertionError("The queue is full!");
            
            return true;
        }
        catch(AssertionError error)
        {
            return false;
        } 
	}

	
	/**
     * method to remove an element from the queue
     * @return the removed process
     */
	@Override
	public Process dequeue() {
		Process process = null;
        
        if(!isEmpty())
        {
            if(front == rear)
            {
                process = queue[front];
                front = -1;
                rear = -1;
            }
            else
            {
                process = queue[front];
                front = (front + 1) % maximumSize;
            }
        }
        else
            throw new AssertionError("The queue is empty!");
        
        return process;
	}

	
	/**
     * method to check if the queue is empty
     * @return boolean value
     */
	@Override
	public boolean isEmpty() {
		
		boolean isEmpty = false;
        
        if(rear == -1 && front == -1)
            isEmpty = true;
        
        return isEmpty;
	}

	
	/**
     * method to check if the queue is full
     * @return boolean value
     */
	@Override
	public boolean isFull() {
		
		return (rear + 1) % maximumSize == front;
	}

	
}

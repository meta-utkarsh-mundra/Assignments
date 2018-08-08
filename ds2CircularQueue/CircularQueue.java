package ds2CircularQueue;

/**
 * This class implements circular queue using array
 *
 */
public class CircularQueue implements Queue {
    private int[] array;
    private int rear = -1;
    private int front = -1;
    private int capacity;

    public CircularQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    /**
     * To add element to queue(enqueue)
     */
    @Override
    public boolean add(int element) {
        if (isEmpty()) {
            front = 0;
            rear = 0;
            array[rear] = element;
            return true;
        } 
        else if (!isFull()) {
            if (rear == array.length - 1) {
                rear = 0;
            } else {
                rear += 1;
            }
            array[rear] = element;
            return true;
        }
        else if(isFull()) {
            throw new AssertionError("Queue is full, cant add!!");
        }
 
        return false;
    }

    /**
     * To delete element from queue(dequeue)
     */
    @Override
    public int delete() {
        if (!isEmpty()) {
            if (front == rear) {
                front = rear = -1; // when queue has only one element
                return array[0];
            } 
            else {
                if (front == array.length - 1) {
                    front = 0;
                    return array[array.length-1];
                } else {
                    front++;
                    return array[front-1];
                }
            }
        }
        else if(isEmpty()){
            throw new AssertionError("Queue is empty, cant dequeue!!");
        }
        else {
            throw new AssertionError("there might be some problem");
        }
    }
    /**
     * To check if queue is empty or not
     */
    @Override
    public boolean isEmpty() {
        boolean flag = false;
        if (front == -1 && rear == -1) {
            flag = true;
        }
        return flag;

    }

    /**
     * To check if queue is full
     */
    @Override
    public boolean isFull() {
        boolean flag = false;
        if ((front == rear + 1) || (front == 0 && rear == array.length - 1)) {
            flag = true;
        }
        return flag;
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
    
    /**
     * Main class to get the input and check it
     * @param args
     */
    public static void main(String args[]) {
        CircularQueue obj = new CircularQueue(3);
        System.out.println(obj.add(1));
        System.out.println(obj.add(5));
        System.out.println(obj.add(1000));
        System.out.println(obj.front);
        System.out.println(obj.rear);
        System.out.println(obj.delete());
        System.out.println(obj.add(1));
        System.out.println(obj.delete());
        System.out.println(obj.delete());
        System.out.println(obj.add(5));
        System.out.println(obj.front);
        System.out.println(obj.rear);
        System.out.println(obj.delete());
        System.out.println(obj.add(1));
        System.out.println(obj.add(5));
        System.out.println(obj.front);
        System.out.println(obj.rear);
        System.out.println(obj.isEmpty());
    }
}
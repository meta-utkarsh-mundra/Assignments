package simpleQueue;

import java.util.Scanner;

/**
 * This is main class for queue through which user will interact
 */
public class QueueArrayMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = input.nextInt();
		QueueArray arrayObject = new QueueArray(size);

		while (true) {
			System.out.println("\nChoose option:-");
			System.out.println(" press 1 to Push  " + "2 to Pop  " + "\n3 to check if it is Full  "
					+ "4 to check if it is Empty  " + "5 to Display elements  " + "\n and 6 To exit  \n");
			int response = input.nextInt();

			switch (response) {
			case 1: {
				System.out.println("Enter the value you want to push");
				int value = input.nextInt();
				arrayObject.add(value);
				break;
			}
			case 2: {
				System.out.println("Popped Element = " + arrayObject.delete());
				break;
			}
			case 3: {
				System.out.println("Full status = " + arrayObject.isFull());
				break;
			}
			case 4: {
				System.out.println("Empty status = " + arrayObject.isEmpty());
				break;
			}
			case 5: {
				arrayObject.display();
				break;
			}
			case 6: {
				System.out.println("Exiting...");
				System.exit(0);
			}
			default: {
				System.out.println("Wrong input");
			}
			}
		}
		
	}
}

package ds1;

import java.util.Scanner;

/**
 * This is main class for queue through which user will interact
 */
public class QueueLinkedListMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		QueueLinkedList object = new QueueLinkedList();

		while (true) {
			System.out.println("\nChoose option:-");
			System.out.println("1.Add  " + "2.delete  " + "3.Full  "
					+ "4.Empty  " + "5.To exit  \n");
			int response = input.nextInt();

			switch (response) {
			case 1: {
				System.out.println("Enter the value you want to add");
				int value = input.nextInt();
				object.add(value);
				break;
			}
			case 2: {
				System.out.println("Deleted Element = " + object.delete());
				break;
			}
			case 3: {
				System.out.println("Full status = " + object.isFull());
				break;
			}
			case 4: {
				System.out.println("Empty status = " + object.isEmpty());
				break;
			}
			case 5: {
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

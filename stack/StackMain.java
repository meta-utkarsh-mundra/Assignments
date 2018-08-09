package stackImplementation;

import java.util.Scanner;

/**
 * This is main class for stack through which user will interact
 */
public class StackMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = input.nextInt();
		StackArray arrayObject = new StackArray(size);

		while (true) {
			System.out.println("Choose option:-");
			System.out.println("press 1 to Push, 2 to Pop, 3 to Peek, 4 to check Empty status \n"
					              + ", 5 to check if it is full "
					              + ", 6.Display elements 7.To exit  \n");
			int responseArray = input.nextInt();

			switch (responseArray) {
			case 1: {
				System.out.println("Enter the value you want to push");
				int value = input.nextInt();
				arrayObject.push(value);
				break;
			}
			case 2: {
				System.out.println("Popped Element = " + arrayObject.pop());
				break;
			}
			case 3: {
				System.out.println("top element  = " + arrayObject.peek());
				break;
			}
			case 4: {
				System.out.println("Empty status = " + arrayObject.isEmpty());
				break;
			}
			case 5 : {
				System.out.println("Full status = " + arrayObject.isFull());
				break;
			}
			case 6: {
				arrayObject.display();
				break;
			}
			case 7: {
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
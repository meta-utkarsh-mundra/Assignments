package stackLinkedList;

import java.util.Scanner;

/**
 * This is main class for stack through which user will interact
 */
public class StackLinkedListMain {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StackLinkedList listObject = new StackLinkedList();
		int response, value;
		while (true) {
			System.out.println();
			System.out.println("OPTIONS:- ");
			System.out.println("1. Push");
			System.out.println("2. Pop");
			System.out.println("3. Top Value");
			System.out.println("4. Empty?");
			System.out.println("5. Exit");
			System.out.println("Enter your choice:");
			response = input.nextInt();

			switch (response) {
			case 1:
				System.out.println("Enter value to be pushed:");
				value = input.nextInt();
				listObject.push(value);
				break;

			case 2:
				value = listObject.pop();
				if (value != -1) {
					System.out.println("The popped value is: " + value);
				}
				break;

			case 3:
				value = listObject.peek();
				System.out.println("The top value is: " + value);
				break;

			case 4:
				boolean reply = listObject.isEmpty();
				if (reply) {
					System.out.println("The stack is empty");
				} else {
					System.out.println("The stack is not empty");
				}
				break;

			case 5:
				System.out.println("Exiting...");
				System.exit(0);

			default:
				System.out
						.println("Wrong choice, Please enter a correct option");
			}
		}
	}
}
package Assignment5.LCMHCF;

import java.util.Scanner;

public class LcmHcf {
	Scanner scan = new Scanner(System.in);

	/**
	 * Calculates Highest Common Divisor
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return integer variable reply
	 */
	public static int calculateHcf(int firstNumber, int secondNumber) {
		int reply;
		int remainder = firstNumber % secondNumber;

		if (remainder == 0) {
			return secondNumber;// Base condition
		} else {
			reply = calculateHcf(secondNumber, remainder);// Recursive call
		}

		return reply;
	}

	static int reply;
	/**
	 * Find LCM 
	 * 
	 * @param firstNumber
	 * @param secondNumber
	 * @return integer variable toReturn
	 */
	public static int calculateLcmSimple(int firstNumber, int secondNumber) {
		int toReturn;
		boolean flag = true;
		do {
			if (reply % firstNumber == 0 && reply % secondNumber == 0) {
				flag = false;
				toReturn = reply;
			} else {
				reply++;
				toReturn = calculateLcmSimple(firstNumber, secondNumber);
			}
		} while (flag);
		return toReturn;
	}
	
}

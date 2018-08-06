package adtAndCdt;

import java.lang.Math;

final class Poly {
	final private int n;
	final private int[][] newArray;

	/**
	 * This is default constructor
	 */
	public Poly() {
		n = 0;
		newArray = null;
	}

	/**
	 * This constructor is to initialise the polynomial array with user's input
	 * @param powerCoefficient is the array of power and coefficients passed by user
	 */
	public Poly(int[][] powerCoefficient) {
		int[][] originalArray = Poly.getArray(powerCoefficient);
		int[][] removedSamePower = samePower(originalArray);
		newArray = removeCoefficientZero(removedSamePower);
		n = newArray[0].length;
		checking(newArray);
	}

	/**
	 * This function is to copy the array passed by user
	 * @param powerCoefficient, is tha array passed to make copy
	 * @return the copied array
	 */
	private static int[][] getArray(int[][] powerCoefficient) {
		int[][] array = new int[2][powerCoefficient[0].length];
		for (int i = 0; i < powerCoefficient[0].length; i++) {
			array[0][i] = powerCoefficient[0][i];
			array[1][i] = powerCoefficient[1][i];
		}
		return array;
	}

	/**
	 * This is to check for empty array exception
	 * @param newArray, is the array passed to check
	 */
	private void checking(int[][] newArray) {
		if (n == 0) {
			throw new AssertionError("Set is empty");
		}
	}

	/**
	 * To add the coefficients if their powers are same
	 * @param originalArray is the array passed 
	 * @return the compressed array
	 */
	private int[][] samePower(int[][] originalArray) {
		for (int i = 0; i < originalArray[0].length - 1; i++) {
			int power = originalArray[0][i];
			for (int j = i + 1; j < originalArray[0].length; j++) {
				if (power == originalArray[0][j]) {
					originalArray[1][i] = originalArray[1][i]
							+ originalArray[1][j];
					originalArray[1][j] = 0;
				}
			}
		}
		return originalArray;
	}

	/**
	 * To remove those terms whose coefficients are zero
	 * @param originalArray is array passed to remove zero
	 * @return the processed array
	 */
	private int[][] removeCoefficientZero(int[][] originalArray) {
		int[][] copiedArray = getArray(originalArray);
		int length = copiedArray[0].length;
		int count = 0;
		for (int i = 0; i < length; i++) {
			if (0 == copiedArray[1][i]) {
				count++;
			}
		}
		int arrayLength = length - count;
		int[][] newArray = new int[2][arrayLength];
		for (int i = 0, j = 0; i < length; i++) {
			if (copiedArray[1][i] != 0) {
				newArray[0][j] = copiedArray[0][i];
				newArray[1][j] = copiedArray[1][i];
				j++;
			}
		}
		return newArray;
	}

	/**
	 * This is to evaluate polynomial for a particular value of x
	 * @param value is value of x
	 * @return the evaluated output after putting x value in polynomial
	 */
	public double evaluate(double value) {
		double result = 0;
		for (int j = 0; j < this.n; j++) {
			int x = newArray[0][j];
			double product = Math.pow(value, x);
			result = result + newArray[1][j] * product;
		}
		return result;
	}

	/**
	 * To calculate the degree of polynomial
	 * @return the highest degree
	 */
	public int degree() {
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (newArray[0][i] > max) {
				max = newArray[0][i];
			}
		}
		return max;
	}

	/**
	 * To add two polynomials
	 * @param p1 is the first polynomial passed
	 * @param p2 is the second polynomial passed
	 * @return the array of polynomial after addition
	 */
	public int[][] addPoly(Poly p1, Poly p2) {
		int[][] addition = new int[2][p1.n + p2.n];
		int k = 0;
		for (int i = 0; i < p1.n; i++) {
			addition[0][k] = p1.newArray[0][i];
			addition[1][k] = p1.newArray[1][i];
			k++;
		}
		for (int j = 0; j < p2.n; j++) {
			addition[0][k] = p2.newArray[0][j];
			addition[1][k] = p2.newArray[1][j];
			k++;
		}
		addition = arrangement(addition);
		display(addition);
		return addition;
	}

	/**
	 * This is to arrange the polynomial array in proper order
	 * @param array is the array passed to arrange
	 * @return the arranged array
	 */
	private int[][] arrangement(int[][] array) {
		int[][] arranged = samePower(array);
		arranged = removeCoefficientZero(arranged);
		arranged = sorting(arranged);
		return arranged;
	}

	/**
	 * To multiply two polynomials
	 * @param p1 is the first polynomial passed
	 * @param p2 is the second polynomial passed
	 * @return the array of polynomial after multiplication
	 */	
	public int[][] multPoly(Poly p1, Poly p2) {
		int[][] multiplication = new int[2][p1.n * p2.n];
		int k = 0;
		for (int i = 0; i < p1.n; i++) {
			for (int j = 0; j < p2.n; j++) {
				multiplication[0][k] = p1.newArray[0][i] + p2.newArray[0][j];
				multiplication[1][k] = p1.newArray[1][i] * p2.newArray[1][j];
				k++;
			}
		}
		multiplication = arrangement(multiplication);
		display(multiplication);
		return multiplication;
	}

	/**
	 * To display the polynomial array
	 * @param array passed to display
	 */
	private void display(int[][] array) {
		for (int i = 0; i < array[0].length; i++) {
			System.out.print(array[0][i] + "\t" + array[1][i] + "\n");
		}
	}

	/**
	 * To arrange the array according to their powers
	 */
	private int[][] sorting(int[][] array) {
		int length = array[0].length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (array[0][j] > array[0][j + 1]) {
					int swapPower = array[0][j];
					int swapCoefficient = array[1][j];
					array[0][j] = array[0][j + 1];
					array[1][j] = array[1][j + 1];
					array[0][j + 1] = swapPower;
					array[1][j + 1] = swapCoefficient;
				}
			}
		}
		array = reverse(array, length);
		return array;
	}

	/**
	 * To reverse array so that highest power come first then lower
	 * @param array passed to reverse
	 * @param n is length of array passed
	 * @return the reversed array according to power in descending order
	 */
	private int[][] reverse(int[][] array, int n) {
		int[][] reversed = new int[2][n];
		int j = 0;
		for (int i = n - 1; i >= 0; i--) {
			reversed[0][j] = array[0][i];
			reversed[1][j] = array[1][i];
			j++;
		}
		return reversed;
	}
}

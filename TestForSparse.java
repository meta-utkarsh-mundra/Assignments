package Invariants;
import static org.junit.Assert.*;

import org.junit.Test;


public class TestForSparse {
	
	int matrix1[][] = {{0, 0, 2}, {1, 2, 0}, {1, 2, 1}};
	int matrix2[][] = {{0, 1, 2}, {1, 0, 0}, {1, 2, 1}};
	int matrix3[][] = {{0, 1, 2}, {0, 1, 2}, {1, 1, 1}};
		/**
		 * To test for transpose
		 */
		@Test
		public void testTranspose() {
			Sparse obj = new Sparse(3, 3, matrix1);
			int trans1[][] = obj.transpose();
			assertArrayEquals(
					new int[][] { { 0, 1, 2 }, { 2, 0, 0 }, { 1, 1, 2 } },
					trans1);
		}

		/**
		 * To test for symmetry if matrix is not symmetric
		 */
		@Test
		public void testSymmetryNegative() {
			Sparse objectSymmetry = new Sparse(3, 3, matrix1);
			boolean symmetric = objectSymmetry.isSymmetric();
			assertEquals(false, symmetric);
		}

		/**
		 * To test for symmetry is matrix is symmetric
		 */
		@Test
		public void testSymmetryPositive() {
			Sparse objectSymmetry = new Sparse(3, 3, matrix3);
			boolean symmetric = objectSymmetry.isSymmetric();
			assertEquals(true, symmetric);
		}

		/**
		 * To test for addition of matrix
		 */
		@Test
		public void testaddition() {
			Sparse objectOne = new Sparse(3, 3, matrix1);
			Sparse objectTwo = new Sparse(3, 3, matrix2);
			int[][] add = objectOne.add(objectOne, objectTwo);
			int[][] additionResult = { { 0, 0, -1, -1, 1, 2}, {1, 2, -1, -1, 0, 0},
					{2, 2, -1, -1, 2, 2}};
			assertArrayEquals(add, additionResult);
		}

		/**
		 * To test for multiplication of matrix
		 */
		@Test
		public void testMultiplication() {
			Sparse objectOne = new Sparse(3, 3, matrix1);
			Sparse objectTwo = new Sparse(3, 3, matrix2);	
			int[][] multiplicationResult = objectTwo.multiply(objectOne,
					objectTwo);
			assertArrayEquals(
					new int[][] { {-1, -1, -1, -1, 0, 2}, {-1, -1, -1, -1, 0, 1}, {-1, -1, -1, -1, 4, 1} },
					multiplicationResult);
		}
	
}

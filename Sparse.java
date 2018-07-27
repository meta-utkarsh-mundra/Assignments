package Invariants;
public class Sparse {
		int sparse_matrix[][];
		int sparse_representation[][];
		int count = 0;
		
		/*constructor to initialize values and to find
		  the sparse_representation
		*/
		public Sparse(int a[][]) {
			sparse_matrix = new int[a.length][a[0].length];
			for(int i = 0 ; i < a.length ; i++) {
				for(int j = 0 ; j < a[0].length ; j++) {
					sparse_matrix[i][j] = a[i][j];
				}
			}
			for(int i = 0 ; i < a.length ; i++) {
				for(int j = 0 ; j < a[0].length ; j++) {
					if(a[i][j] != 0) {
						count++;
					}
				}
			}
			sparse_representation = new int[3][count];
			count = 0;
			for(int i = 0 ; i < a.length ; i++) {
				for(int j = 0 ; j < a[0].length ; j++) {
					if(a[i][j] != 0) {
						sparse_representation[0][count] = i;
						sparse_representation[1][count] = j;
						sparse_representation[2][count] = a[i][j];
						count++;
					}
				}
			}
		}
		
		//function to take transpose of a matrix
		public int[][] transpose(int a[][]) {
			Sparse tr1_object = new Sparse(a);
			int transpose[][] = new int[sparse_matrix[0].length][sparse_matrix.length];
			for(int i = 0 ; i < sparse_matrix[0].length ; i++) {
				for(int j = 0 ; j < sparse_matrix.length ; j++) {
					transpose[i][j] = tr1_object.sparse_matrix[j][i];
				}
			}
			Sparse tr2_object = new Sparse(transpose);
			return tr2_object.sparse_representation;
		}
		//function to check if a matrix is symmetric
		public boolean isSymmetric(int a[][]) {
			Sparse sym = new Sparse(a);
			if(sym.transpose(a) == a) {
				return true;
			}
			else {
				return false;
			}
		}
		//function to add two sparse matrices
		public int[][] add(int a[][], int b[][]) {
			int add_result[][] = new int[a.length][a[0].length];
			if(a.length != b.length && a[0].length != b[0].length) {
				throw new AssertionError("matrices cant be added");
			}
			else {
				for(int i = 0 ; i < a.length ; i++) {
					for(int j = 0 ; j < a[0].length ; j++) {
						add_result[i][j] = a[i][j] + b[i][j];
					}
				}
			}
			Sparse add = new Sparse(add_result);	
			return add.sparse_representation;
					
		}
		
		//function to multiply two matrices
		public int[][] multiplyMatrices(int a[][], int b[][]) {
			int mul[][] = new int[a.length][b[0].length];
			for( int i = 0 ; i < a.length ; i++) {
				for(int j = 0 ; j < b[0].length ; j++ ) {
					mul[i][j] = 0;
				}
			}	
			if(a[0].length != b.length) {
				throw new AssertionError("cant multiply matrices");
			}
			else {
				for( int i = 0 ; i < a.length ; i++) {
					for(int j = 0 ; j < b[0].length ; j++ ) {
						for(int k = 0 ; k < a[0].length ; k++) {
							mul[i][j] = mul[i][j] + a[i][k]*b[k][j];
						}
					}
				}
			}
			Sparse multiply = new Sparse(mul);
			return multiply.sparse_representation;
		}
	
}

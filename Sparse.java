package Invariants;
public class Sparse {
	int sparse_matrix[][];
	int sparse_representation[][];
	int count;
	int temp = 0;
	int row;
	int column;
	//constructor to initialize values
	public Sparse(int row, int column, int a[][]) {
		if((a.length == 0) || (a[0].length == 0) || (row == 0) || (column == 0)) {
			throw new AssertionError("your matrix is empty");
		}
		this.row = row;
		this.column = column;
		sparse_representation = new int[3][a[0].length];
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < a[0].length ; j++) {
				sparse_representation[i][j] = a[i][j];
			}
		}
	}
	//funtion to sort according to rows
	public int[][] sort(int a[][]) {
		if((a.length == 0) || (a[0].length == 0)) {
			throw new AssertionError("your matrix is empty");
		}
		for(int i = 0 ; i < a[0].length ; i++) {
			for(int j = i+1 ; j < a[0].length ; j++) {
				if(a[0][i] == a[0][j] && a[1][i] == a[1][j]) {
					a[2][i] = a[2][i] + a[2][j];
					a[2][j] = -1;
					a[0][j] = -1;
					a[1][j] = -1;
				}
				if(a[0][i] > a[0][j]) {
					temp = a[0][i];
					a[0][i] = a[0][j];
					a[0][j] = temp;
					
					temp = a[1][i];
					a[1][i] = a[1][j];
					a[1][j] = temp;
					
					temp = a[2][i];
					a[2][i] = a[2][j];
					a[2][j] = temp;
				}
				if(a[2][i] == 0) {
					a[2][i] = -1;
					a[1][i] = -1;
					a[0][i] = -1;
				}
			}	
		}
		return a;
	}
	//function to compute transpose
	public int[][] transpose() {
		int transpose[][] = new int[3][sparse_representation[0].length];
		for(int j = 0 ; j < sparse_representation[0].length ; j++) {
			transpose[0][j] = sparse_representation[1][j];
			transpose[1][j] = sparse_representation[0][j];
			transpose[2][j] = sparse_representation[2][j];
		}
		sort(transpose);
		return transpose;
	}
	//function to check if a matrix is symmetric or not
	public boolean isSymmetric() {
		int[][] isSym = transpose();
		boolean result = false;
		for(int i = 0 ; i < sparse_representation.length ; i++) {
			for(int j = 0 ; j < sparse_representation[0].length ; j++){
				if(sparse_representation[i][j] == isSym[i][j]){
					result = true;
				}
				else {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	//function to add two matrices
	public int[][] add(Sparse obj1, Sparse obj2) {
		boolean flag = false;
		if(obj1.row != obj2.row || obj1.column != obj2.column) {
			throw new AssertionError("cant be added");
		}
		int count = 0;
		int add[][] = new int[3][obj1.sparse_representation[0].length+obj2.sparse_representation[0].length];
		int len;
		if(obj1.sparse_representation[0].length > obj2.sparse_representation[0].length) {
			len = obj2.sparse_representation[0].length;
		}
		else {
			len = obj1.sparse_representation[0].length;
		}
		
		for(int i = 0 ; i < obj1.sparse_representation[0].length ; i++) {
			add[0][i] = obj1.sparse_representation[0][i];
			add[1][i] = obj1.sparse_representation[1][i];
			add[2][i] = obj1.sparse_representation[2][i];
		
		}	
		for(int i = 0 ; i < len ; i++) {
			if(obj1.sparse_representation[0][i] == obj2.sparse_representation[0][i] && obj1.sparse_representation[1][i] == obj2.sparse_representation[1][i]) {
				add[0][i] = obj1.sparse_representation[0][i];
				add[1][i] = obj1.sparse_representation[1][i];
				add[2][i] = obj1.sparse_representation[2][i] + obj2.sparse_representation[2][i];
				count++;
			}
		}
		for(int i = 0 ; i < obj2.sparse_representation[0].length ; i++) {
			flag = false;
			for(int j = i ; j < obj2.sparse_representation[0].length ; j++) {
				if(add[0][i] == obj2.sparse_representation[0][i] && add[1][i] == obj2.sparse_representation[1][i]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				add[0][obj1.sparse_representation[0].length+i] = obj2.sparse_representation[0][i];
				add[1][obj1.sparse_representation[0].length+i] = obj2.sparse_representation[1][i];
				add[2][obj1.sparse_representation[0].length+i] = obj2.sparse_representation[2][i];
			}
		}
		sort(add);
		return add;
	}
	//function to multiply two matrices
	public int[][] multiply(Sparse object1, Sparse object2) {
		if(object1.column != object2.row) {
			throw new AssertionError("cant multiply");
		}
		int mult[][] = new int[3][object1.sparse_representation[0].length+object2.sparse_representation[0].length];
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < object1.sparse_representation[0].length+object2.sparse_representation[0].length; j++) {
				mult[i][j] = 0;
			}
		}
		for(int i = 0 ; i < object1.sparse_representation[0].length ; i++) {
			for(int j = 0 ; j < object2.sparse_representation[0].length ; j++) {
		        if(object1.sparse_representation[1][i] == object2.sparse_representation[0][j]) {
			        mult[0][i] = object1.sparse_representation[0][i];
			        mult[1][i] = object2.sparse_representation[1][j];
			        mult[2][i] = mult[2][i] + (object1.sparse_representation[2][i] * object2.sparse_representation[2][j]);
		        }
			}
		}
		sort(mult);
		return mult;
	}
}

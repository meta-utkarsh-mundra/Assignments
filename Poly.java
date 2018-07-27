package adtAndCdt;

import java.util.ArrayList;

public final class Poly {
	int poly_array[][];
	int row;
	
	//constructor to initialize values
	public Poly(int a[][]) {
	    row = a[0].length;
		poly_array = new int[row][2];
	    for(int i = 0 ; i < row ; i++) {
	    	for(int j = 0 ; j < 2 ; j++) {
	    		poly_array[i][j] = a[i][j];
	    	}
	    }
	    for(int i = 0 ; i < a[0].length-1 ; i++) {
			 for(int j = i+1 ; j < a[0].length ; j++) {
				 if(a[0][i] == a[0][j]) {
					 a[1][i] += a[1][j];
					 a[0][j] = 0;
					 a[0][j] = 0;
				 }
			 }
		 }
	} 
	
	//function to evaluate a polynomial
    public float evaluate(float x) {
    	
	    float sum = 0;
	    for(int i = 0 ; i < row ; i ++) { 
	    	for(int j = 0 ; j < 2 ; j++) {
	    		sum += Math.pow(x, poly_array[i][0])*poly_array[i][1];
	    	}
	   	}
	   	return sum;
	   }
    
    //function to calculate degree of a polynomial
	 public int degree() {
		 
	    int max = poly_array[0][0]; 
	    for(int i = 0 ; i < row ; i++) {
	    	if(poly_array[0][i] > max) {
		    	max = poly_array[0][i];
			}
		}
		return max;
	 }
	 
	 //function to add two polynomials
	 public Poly addPoly(Poly p1, Poly p2) {
		ArrayList<Integer>arrList_coef = new ArrayList<Integer>();
		ArrayList<Integer>arrList_power = new ArrayList<Integer>();
		//add powers of first object
		for(int i = 0 ; i < p1.poly_array[0].length ; i++) {
			arrList_power.add(p1.poly_array[0][i]);
		}
		//add coefficients of first object
		for(int i = 0 ; i < p1.poly_array[1].length ; i++) {
			arrList_coef.add(p1.poly_array[1][i]);
		}
		/*adding powers of second object
		 * if powers matched, coefficient will be added
		 * else they both will get added in their respective 
		 * array lists
		 */
		for(int i = 0 ; i < p2.poly_array[0].length ; i++) {
			int temp = -1;
			temp = arrList_power.indexOf(p2.poly_array[0][i]);
			if(temp != -1){
			   arrList_coef.set(temp, new Integer(arrList_coef.get(temp).intValue() + p2.poly_array[1][i] ) );
		    }
			else {
				arrList_power.add(p2.poly_array[0][i]);
				arrList_coef.add(p2.poly_array[1][i]);
			}
		}
		int after_add[][] = new int[2][arrList_power.size()];
		for(int i = 0 ; i < arrList_power.size() ; i++) {
			after_add[0][i] = arrList_power.get(i);
			after_add[1][i] = arrList_coef.get(i);
		}
		Poly P = new Poly(after_add);
		return P;
	 }
	 
	 //function to multiply two numbers
	 public Poly multiplyPoly(Poly p1, Poly p2) {
		 int arr1[][] = new int[2][p1.poly_array[0].length];
		 int arr2[][] = new int[2][p2.poly_array[0].length];
		 int arr_result[][] = new int[2][p1.poly_array[0].length*p2.poly_array[0].length];
		 int count = 0;
		 for(int i = 0 ; i < p1.poly_array[0].length ; i++) {
			 arr1[0][i] = p1.poly_array[0][i];
			 arr1[1][i] = p1.poly_array[1][i];
		 }
		 for(int i = 0 ; i < p2.poly_array[0].length ; i++) {
			 arr2[0][i] = p2.poly_array[0][i];
			 arr2[1][i] = p2.poly_array[1][i];
		 }
		 for(int i = 0 ; i < p1.poly_array[0].length ; i++) {
			 for(int j = 0 ; j < p2.poly_array[0].length ; j++) {
				 arr_result[0][count] = arr1[0][i] + arr2[0][j];
				 arr_result[1][count] = arr1[0][i] * arr2[0][j];
			 }
		 }
		 
		 Poly pForMultiply = new Poly(arr_result);
		 return pForMultiply;
	 }
}	

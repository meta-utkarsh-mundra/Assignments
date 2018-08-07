package Assignment5.LinearBinary;

import java.util.Scanner;

class Search{
	
	
	public static int LinearSearch(int[] array, int element, int index) {
		int position;
		if( index < array.length ) {
			if(array[index] == element) {
				position = index;
			}
			else {
				position = LinearSearch(array, element, index+1);
			}
		}else {
			position = -1;
		}
		
		
		return position;
	}
	
	public static int BinarySearch(int[] array, int element, int start, int end) {
		int position=-1;
		if(start<=end){
			int mid= (start+end)/2;
			
			if(array[mid]==element){
				position = mid;
			}
			else if(array[mid] > element){
				position = BinarySearch(array, element, start, mid-1);
			}
			else if(array[mid] < element){
				position = BinarySearch(array, element, start+1, end);
			}
		}
		
		return position;
	}
	
}

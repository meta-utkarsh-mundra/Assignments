package Test;
import java.util.Scanner;
class CalculateFixxy {
	int temp = 0;
	int[] fixXy(int x, int y, int arr[]) {
		int number_of_x = 0;
		int number_of_y = 0;
		int size = arr.length;
		if(size == 0) {
			throw new AssertionError("array is empty");
		}
		if(arr[size-1] == x) {
			throw new AssertionError("can't fixxy, as x is on the last position");
		}
		for(int i = 0 ; i < size ; i++) {
			if(arr[i] == x){
				number_of_x++;
			}
			else if(arr[i] == y) {
				number_of_y++;
			}
		}
		for(int i = 0 ; i < size ; i++) {
			if(arr[i] == x && arr[i+1] == x) {
				throw new AssertionError("two Xs are consecutive");
			}
		}
		if(number_of_x != number_of_y) {
			throw new AssertionError("sorry dude, can't fixXy");
			}
		
		for(int i = 0 ; i < size-1 ; i++) {
			if(arr[i] == x){
				temp = arr[i+1];
				for(int j = 0 ; j < size ; j++){
					if((j > 0 && arr[j] == y && arr[j-1] != x) || (j==0 && arr[j] == y)){
						arr[i+1] = y;
						arr[j] = temp;
						break;
					}
					
				}
			}
		}
		for(int i = 0 ; i<arr.length ; i++){
			System.out.println(arr[i]);
		}
		return arr;
	}	
}
public class Fixxy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array : ");
		int size = sc.nextInt();
		System.out.println("enter the array");
		int fixxy_array[] = new int[size];
		for(int i = 0 ; i < size ; i++){
			fixxy_array[i] = sc.nextInt();
		}
	    System.out.println("enter the two elements to fix : ");
	    int x = sc.nextInt();
	    int y = sc.nextInt();
		CalculateFixxy object = new CalculateFixxy();
		object.fixXy(x, y, fixxy_array);
	}
}


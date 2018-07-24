package Test;
import java.util.Scanner;
class CheckSplitPoint {
	int splitPoint(int arr[]) {
		if(arr.length == 0) {
			throw new AssertionError("array is empty");
		}
		int sum = 0, i, j;
		int inner_sum = 0;
		for(i = 0 ; i < arr.length-1 ; i++) {
			sum = sum + arr[i];
			inner_sum = 0;
			for(j = i+1 ; j < arr.length ; j++){
				inner_sum = inner_sum + arr[j];
			}
			if(sum == inner_sum){
				break;
			}
		}
		if(sum == inner_sum){
			return i+1;
		}
		else {
			return -1;
		}
	}
}
public class SplitArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array : ");
		int size = sc.nextInt();
		int split_array[] = new int[size];
		System.out.println("enter the array : ");
		for(int i = 0 ; i < size ; i++) {
			split_array[i] = sc.nextInt();
		}
		CheckSplitPoint object = new CheckSplitPoint();
		System.out.println("Split point of this array is : "+object.splitPoint(split_array));
	}

}

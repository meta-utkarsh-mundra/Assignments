package Test;
import java.util.Scanner;
class CalculateClumps {
	int totalClumps(int arr[]) {
		if(arr.length == 0){
			throw new AssertionError("array is empty");
		}
		int number_of_clumps[];
		int sum = 0;
		number_of_clumps = new int[arr.length];
		for(int i = 0 ; i < arr.length-1 ; i++) {
			if(arr[i] == arr[i+1]) {
				number_of_clumps[i] = 1;
				for(int j = i+1 ; j < arr.length ; j++ ) {
					int count = j;
					if(count+1 < arr.length && arr[j] == arr[count+1]) {
						number_of_clumps[i] = 1;
					}
					else {
						i = j+1;
						break;
					}
				}
			}
		}
		for(int i = 0 ; i < number_of_clumps.length ; i++) {
			sum = sum + number_of_clumps[i];
		}
		return sum;
	}
}
public class Clumps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array : ");
		int size = sc.nextInt();
		int arr_clumps[] = new int[size];
		System.out.println("enter the array : ");
		for(int i = 0 ; i < size ; i++) {
			arr_clumps[i] = sc.nextInt();
		}
		CalculateClumps object = new CalculateClumps();
		System.out.println(object.totalClumps(arr_clumps));
	}

}
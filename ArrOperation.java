package Test;
import java.util.Scanner;
class MaxMirror{
	public int maxMirror(int[] nums) {
		  if(nums.length == 0){
			  throw new AssertionError("your array is empty");
		  }
		  final int len=nums.length;
		  if(len==0)
		  return 0;
		  int maxCount=1;
		  boolean flag=false;
		  for(int i=0;i<len;i++) {
		     int tempCount=1;
		     int count=i;
		     flag=false;
		     for(int j=len-1;j>=0&&(count<len);j--) {
		        if((nums[count]==nums[j])&&!(flag)) {
		          flag=true;
		          count++;
		          continue;
		        }
		        if((nums[count]==nums[j])&&(flag)) {
		          tempCount++;
		          count++;
		          maxCount=(tempCount>maxCount)?tempCount:maxCount;
		          continue;
		        }
		        if(!(nums[count]==nums[j])&&(flag)) {
		          flag=false;
		          count=i;
		          tempCount=1;
		          continue;
		        }
		        if((j==count)||(j-count)==1) {
		          flag=false;
		          break;
		          }

		      }
		  }    
		      return maxCount;    
		}
}
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
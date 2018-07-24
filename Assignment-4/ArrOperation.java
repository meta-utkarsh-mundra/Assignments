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
		        if(!(nums[i]==nums[j])&&(flag)) {
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
public class ArrOperation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of the array : ");
		int size = sc.nextInt();
		int arr_mirror[] = new int[size];
		System.out.println("\nenter the array : ");
		for(int i = 0 ; i < size ; i++) {
			arr_mirror[i] = sc.nextInt();
		}
		System.out.println("\nyour array is : ");
		for(int i = 0 ; i<size ; i++) {
			System.out.print(arr_mirror[i]+" ");
		}
		MaxMirror object = new MaxMirror();
		System.out.println("\nmaximimum mirror count is :  ");
		System.out.println(object.maxMirror(arr_mirror));
	}

}

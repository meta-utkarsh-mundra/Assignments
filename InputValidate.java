package Assignment6.input;
import java.util.Scanner;

public class InputValidate{
	
	public static int isInt(){
		int integerValue=0;
		Scanner scan = new Scanner(System.in);
		boolean flag ;
		do{
			flag = false;
			if(scan.hasNextInt())
			{
			 integerValue = scan.nextInt();
			}	
			else{
			flag =true;
			System.out.println("Please enter a Integer numeric value");
			scan.next();
			}
		}while(flag);
		return integerValue;
	}
	
	public static int isPositiveInt(){
		int integerValue = -1;
		boolean flag;
		do{
		flag = false;
		try{
			integerValue = isInt();
			if(integerValue<=0)
			{
				throw new Exception("Integer is Negative");
			}
		}catch(Exception e)
		{	
			flag = true;
			System.out.println("Please enter a non negative Integer.");
		}
		}while(flag);
		return integerValue;
	}
	
	public static int isPositiveIntRange(int start,int end){
		int integerValue =-1;
		boolean flag;
		do{
			flag=false;
			try{
				integerValue = isPositiveInt();
				if(integerValue < start || integerValue > end)
				{
					throw new Exception("Integer is not in required specific Range");
				}
			}catch (Exception e)
			{
				flag = true;
				System.out.println("Please enter the Integer in the required specific range");
			}
		}while(flag);
		return integerValue;
	}
}
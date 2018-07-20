package Initials;
import java.util.*;
class Stack{
	int size;
	int index=-1;
	int arr[];
	public Stack(){
	}
	public Stack(int size)	{
		this.size=size;
		arr=new int[size];
	}
	public void push(int element){
		if(isFull()){
			System.out.println("stack is full");
		}
		else{
			arr[index+1]=element;
			index++;
			System.out.println("an element has been added ");
			System.out.println("stack is : \n ");
			for(int i=0;i<=index;i++){
				System.out.print(" "+arr[i]);
			}
		}
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("stack is already empty");
			return 0;
		}
		else{
			arr[index]=0;
			System.out.println("an item has been deleted ");
			return arr[--index];
		}
	}
	public boolean isEmpty(){
		return index==-1?true:false;
	}
	public boolean isFull()	{
		return index==size-1?true:false;
	}
}
public class UseStack{
	public static void main(String args[]){
	   	Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of stack");
		int size1=sc.nextInt();
		Stack st=new Stack(size1);
		System.out.println("\n------");
		while(true){
			System.out.println("\npress 1 to push");
			System.out.println("\npress 2 to pop");
			System.out.println("\npress 3 to exit");
			int button=sc.nextInt();
			switch(button){
			case 1 :{
				System.out.println("\nenter the element to push : ");
				int element=sc.nextInt();
				st.push(element);
				break;
			}
			case 2 :{
				st.pop();
				break;
			}
			case 3:{
				System.exit(0);
			}
			default :{
				System.out.println("\npress again ");
				break;
			}
			}
		}
	}
}


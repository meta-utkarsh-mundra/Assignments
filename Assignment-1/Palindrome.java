package Initials;
import java.util.Scanner;
class InputStack{
	int size;
	int index=-1;
	char arr[];
	public InputStack(){
	}
	public InputStack(int size)	{
		this.size=size;
		arr=new char[size];
	}
	public void push(char element){
		if(isFull()){
			System.out.println("stack is full");
		}
		else{
			arr[index+1]=element;
			index++;
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
			System.out.println("stack is : \n ");
			for(int i=0;i<index;i++){
				System.out.print(" "+arr[i]);
			}
			return arr[--index];
		}
	}
	public boolean isEmpty(){
		return index==-1?true:false;
	}
	public boolean isFull()	{
		return index==size-1?true:false;
	}
	String checkReverse(){
	char reverse[] = new char[size];
	for(int i = size-1;i>=0;i--){
		reverse[size-i-1]=arr[i];
	}
	String str1=null;
	for(int i=0;i<size-1;i++){
		str1=str1+reverse[i];
	}
	String str2=null;
	for(int i=0;i<size-1;i++){
		str2=str2+arr[i];
	}
	if(str1.equals(str2)){
		return "its a palindrome";
	}
		return "its not a palindrome";
}
}
public class Palindrome {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("enter the size of stack");
			int size1=sc.nextInt();
			InputStack st=new InputStack(size1);
			System.out.println("\nenter the element to push (letter by letter) : ");
			for(int i=0;i<size1;i++){
			char element=sc.next().charAt(0);
			st.push(element);
			}
			System.out.println("\npress 1 to check if its a palindrome or not and press to pop an element");
			int button=sc.nextInt();
			switch(button){
			case 1 : {
				System.out.println(st.checkReverse());
				break;
			}
			case 2 :{
				st.pop();
				break;
			}
			default : {
				System.out.println("enter a valid choice ");
			}
	    }
			System.out.println("\npress y to continue else press n");
			String choice=sc.next();
			if(choice=="n") {
			break;
	}
	}
}
}

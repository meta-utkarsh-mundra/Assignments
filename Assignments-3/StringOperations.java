package Initials;
import java.util.Scanner;
public class StringOperations {
	public static void main(String args[]){
		String str1=null;
		String str2=null;
		Scanner SC=new Scanner(System.in);
		Scanner SC1=new Scanner(System.in);
		Scanner SC2=new Scanner(System.in);
		StringFunctions SF = new StringFunctions();
		while (true){
			System.out.println("\npress 1 to compare two strings, press 2 to find reverse of a string, ");
			System.out.println("press 3 to find opposite case and press 4 to find the largest word in a string");
			int input = SC.nextInt();
			switch(input){
			case 1 : {
				System.out.print("Enter string1: ");
				str1=SC1.nextLine();
				System.out.print("Enter string2: ");
				str2=SC2.nextLine();
				//Calling stringCompare function
				int isStringEqual = SF.stringCompare(str1,str2);
				System.out.println(isStringEqual);
				break;
			}
			case 2 : {
				//reverse of string
				System.out.print("Enter string to find reverse of string: ");
				str1=SC1.nextLine();
				String reverseString = SF.stringReverse(str1);
				System.out.println("Reverse of String = "+reverseString);
				break;
			}
			case 3 : {
				//opposite case
				System.out.print("Enter string to find opposite case: ");
				str1=SC1.nextLine();
				String oppositecase = SF.convertOpposite(str1);
				System.out.println("Opposite case of String = "+oppositecase);
				break;
			}
			case 4 : {
				//largest string
				System.out.print("Enter string to find largest word: ");
				String str=SC1.nextLine();
				String largestString = SF.largestWord(str);
				System.out.println("Largest word of string = "+largestString);
				break;
			}
			default : {
				System.out.println("enter a valid choice ");
				break;
			}
			}
			System.out.println("press n to discontinue ");
			String st = SC.next();
			if(st=="n"){
				break;
			}
		}
	}
}
class StringFunctions {
	//compare strings
	public int stringCompare(String str1, String str2){
		//check whether length of string is equal or not
		if(str1.length()!=str2.length())
			return 0;
		boolean flg=true;
		//comparing string character wise
		for(int loop=0; loop<str1.length();loop++){
			if(str1.charAt(loop)!=str2.charAt(loop)){
				flg=false;
				break;
			}
		}
		if(flg)
			return 1;
		else
			return 0;
	}
	//reverse of string
	public String stringReverse(String str1){
			   StringBuilder sb = new StringBuilder();
			   for(int i = str1.length() - 1; i >= 0; --i)
			     sb.append(str1.charAt(i));
			   return sb.toString();
	}
	//convert 
	public String convertOpposite(String str1){
	    int ln = str1.length();
	    char str[] = str1.toCharArray();
	      // Conversion according to ASCII values
	    for (int i=0; i<ln; i++){
	        if (str[i]>='a' && str[i]<='z')
	        //Convert lowercase to uppercase
	            str[i] = (char) (str[i] - 32);
	        else if(str[i]>='A' && str[i]<='Z')
	        //Convert uppercase to lowercase
	            str[i] = (char) (str[i] + 32);
	    }
	    String string = new String(str);
	    return string;
	}
	
	//largest word of string
	public String largestWord(String str){
		String[] word=str.split(" ");
        String rts=" ";
        for(int i=0;i<word.length;i++){
            for(int j=1+i;j<word.length;j++){
                if(word[i].length()>word[j].length()){
                    rts=word[i];
                }
                if(word[i].length()<word[j].length()){
                    rts=word[j];
                }
                if(word[i].length()==word[j].length()){
                    rts=word[j];
                }
            } 
        }
        return rts;
	}
}
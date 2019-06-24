package Initials;
import java.util.Scanner;
class Converter{
    public static int getDecimal(String hex){  
        String digits = "0123456789ABCDEF";  
                 hex = hex.toUpperCase();  
                 int val = 0;  
                 for (int i = 0; i < hex.length(); i++)  
                 {  
                     char c = hex.charAt(i);  
                     int d = digits.indexOf(c);  
                     val = 16*val + d;  
                 }  
                 return val;  
    }  
    public static String toHex(int decimal){    
         int rem;  
         String hex="";   
         char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};  
         while(decimal>0)  
         {  
              rem=decimal%16;   
              hex=hexchars[rem]+hex;   
              decimal=decimal/16;  
         }  
         return hex;  
    }    
}
class Operations{
    Converter object=new Converter();
    String add(String hex1, String hex2) {
        int i= object.getDecimal(hex1)+object.getDecimal(hex2);
        return object.toHex(i);
    }
    String subtract(String hex1, String hex2) {
        int i= object.getDecimal(hex1)-object.getDecimal(hex2);
        if(i<0){
            System.out.println("\nit is giving a negative value, sorry");
            return "0";
        }
        return object.toHex(i);
    }
    String multiply(String hex1, String hex2) {
        int i= object.getDecimal(hex1)*object.getDecimal(hex2);
        return object.toHex(i);
    }
    String divide(String hex1, String hex2) {
        int i= object.getDecimal(hex1)/object.getDecimal(hex2);
        return object.toHex(i);
    }
}
class CompareTwoHexNumbers{
    Converter obj=new Converter();
    String compare(String hex1, String hex2) {
        int i= obj.getDecimal(hex1)-obj.getDecimal(hex2);
        if(i==0) {
            return  "both the numbers are equal" ;
        }
        else if(i>0) {
            return "first number is greater";
        }
        else return "second number is greater";
    }
}
public class HexCalc {

    public static void main(String[] args) {
        Operations op = new Operations();
        CompareTwoHexNumbers compareNums=new CompareTwoHexNumbers();
        Scanner hexDec=new Scanner(System.in);
        while(true) {
            System.out.println("\nall the operations performed here will be related to hexaDecimal numbers\n");
            System.out.println("\n\npress 1 to perform any arithematic operation\npress 2 to compare them ");
            System.out.println("press 3 to represent it's decimal representation\nand press 4 to convert any decimal to hexadecimal : ");
            int switch_case=hexDec.nextInt();
            switch(switch_case) {
            case 1 : {
                System.out.println("\n\nchoose the operation you want to perform : ");
                System.out.println("\npress 1 to add two hexadecimal numbers ");
                System.out.println("\npress 2 to subtract two hexadecimal numbers ");
                System.out.println("\npress 3 to multiply two hexadecimal numbers ");
                System.out.println("\npress 4 to divide two hexadecimal numbers : \n\n");
                int inner_case=hexDec.nextInt();
                switch(inner_case) {
                case 1 : {
                    System.out.println("\n\nenter the first number : ");
                    String num1=hexDec.next();
                    System.out.println("enter the second number : ");
                    String num2=hexDec.next();
                    System.out.println("\n addition is : "+op.add(num1, num2));
                    break;
                }
                case 2 : {
                    System.out.println("\n\nenter the first number : ");
                    String num1=hexDec.next();
                    System.out.println("enter the second number : ");
                    String num2=hexDec.next();
                    System.out.println("\n subtraction is : "+op.subtract(num1, num2));
                    break;
                }
                case 3 : {
                    System.out.println("\n\nenter the first number : ");
                    String num1=hexDec.next();
                    System.out.println("enter the second number : ");
                    String num2=hexDec.next();
                    System.out.println("\nmultiplication is : "+op.multiply(num1, num2));
                    break;
                }
                case 4 : {
                    System.out.println("\n\nenter the first number : ");
                    String num1=hexDec.next();
                    System.out.println("enter the second number : ");
                    String num2=hexDec.next();
                    System.out.println("\n  after division : "+op.divide(num1, num2));
                    break;
                }
                default : {
                    System.out.println("\nplease enter a valid arithematic operation");
                    break;
                }
                }
                break;
            }
            case 2 : {
                System.out.println("\n\nenter the first number : ");
                String num1=hexDec.next();
                System.out.println("enter the second number : ");
                String num2=hexDec.next();
                compareNums.compare(num1, num2);
                break;
            }
            case 3 : {
                System.out.println("enter a hexadecimal to convert it into decimal");
                String num=hexDec.next();
                System.out.println("\nand its decimal representation is :"+Converter.getDecimal(num));
                break;
            }
            case 4 : {
                System.out.println("enter a decimal to convert it into hexadecimal");
                int num=hexDec.nextInt();
                System.out.println("\nand its decimal representation is :"+Converter.toHex(num));
                break;
            }
            default : {
                System.out.println("\n\nyou must have entered a wrong choice, try again");
                break;
            }
            }
            System.out.println("\npress y to continue else press n");
            String choice=hexDec.next();
            if(choice=="n") {
            break;
            }
        }
    }

}

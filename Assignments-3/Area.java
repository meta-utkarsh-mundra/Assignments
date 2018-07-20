package Initials;
import java.util.Scanner;
//class to calculate area of different shapes
class CalculateArea{
	//it calculates the area of triangle
	double triangle(double width, double height){
		return (width * height)/2;
	}
	//it calculates the area of a rectangle
	double rectangle(double width, double height){
		return width * height;
	}
	//it calculates the area of square
	double square(double width){
		return width * width;
	}
	//it calculates the area of the circle
	double circle(double radius){
		return Math.PI * radius * radius;
	}
}
public class Area {
	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);//scanner class object
		CalculateArea object = new CalculateArea();
		while(true){
		System.out.println("\npress 1 to calculate triangle's are,\npress 2 to calculate rectangle's area, ");
		System.out.println("press 3 to calculate square's area,\npress 4 to calculate circle's area ");
		int case_input = inputs.nextInt();
		switch(case_input){
		case 1 : {
			//calling method to calculate triangle's area
			System.out.println("\nenter the width of the triangle : ");
			double width = inputs.nextDouble();
			System.out.println("\nenter the height of the triangle : ");
			double height = inputs.nextDouble();
			System.out.println("\narea is "+object.triangle(width, height));
			break;
		}
		case 2 : {
			//calling method to calculate rectangle's area
			System.out.println("\nenter the width of the rectangle : ");
			double width = inputs.nextDouble();
			System.out.println("\nenter the height of the rectangle : ");
			double height = inputs.nextDouble();
			System.out.println("\narea is "+object.rectangle(width, height));
			break;
		}
		case 3 : {
			//calling method to calculate square's area
			System.out.println("\nenter the width of the square : ");
		    double width = inputs.nextDouble();
		    System.out.println("\narea is "+object.square(width));
		    break;
		}
		case 4 : {
			//calling method to calculate circle's area
			System.out.println("\nenter the radius of the circle : ");
			double radius = inputs.nextDouble();
			System.out.println("\narea is "+object.circle(radius));
			break;
		}
		default : {
			System.out.println("\n we dont claculate that here, sorry : ");
			break;
		}
		}
		System.out.println("\n\npress y to continue or n to stop : ");
		String breaking=inputs.next();
		if(breaking=="n"){
			break;
		}
	}
	}
}

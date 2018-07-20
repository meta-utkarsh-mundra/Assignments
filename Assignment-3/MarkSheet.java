package Initials;
import java.util.Scanner;
class Marks{
	//calculates average marks
	double average(int n, double marks[]){
		double sum=0;//calculates total marks
		//i is for iterating
		for(int i=0;i<n;i++){
			sum += marks[i];
		}
		return sum/n;
	}
	//calculates maximum marks
	double maximum(int n, double marks[]){
		double maximum = marks[0];
		for(int i=1;i<n;i++){
			maximum = maximum < marks[i] ? marks[i] : maximum;
		}
		return maximum;
	}
	//calculates minimum marks
	double minimum(int n, double marks[]){
		double minimum = marks[0];
		for(int i=1;i<n;i++){
			minimum = minimum > marks[i] ? marks[i] : minimum;
		}
		return minimum;
	}
	//it returns the total number of students passed
	int numOfStudentsPassed(int n, double marks[]){
		int total_students_passed = 0;
		for(int i=0;i<n;i++){
			total_students_passed = marks[i] >= 40 ? total_students_passed+1 : total_students_passed;
		}
		return total_students_passed;
	}
}
public class MarkSheet {

	public static void main(String[] args) {
		Marks newMarks = new Marks();
		Scanner sc = new Scanner(System.in);//Scanner class object
		System.out.println("\nenter the number of students : ");
		int number_of_students = sc.nextInt();
		double marks[] = new double[number_of_students];
		System.out.println("\nenter the marks of each student : ");
		//taking all the marks in input
		for(int i=1;i<=number_of_students;i++){
			System.out.println("Student"+i);
			marks[i-1]=sc.nextDouble();
		}
		//operations you want to perform
		System.out.println("\n\npress 1 to calculate average, press 2 to calculate maximum marks,");
		System.out.println(" \npress 3 to calculate minimum marks and press 4 to check how many students have passed");
		int button=sc.nextInt();
		switch(button){
		case 1 : {
			System.out.printf("\naverage is %.2f",newMarks.average(number_of_students, marks));
			break;
		}
		case 2 : {
			System.out.printf("\nmaximum marks is %.2f",newMarks.maximum(number_of_students, marks));
			break;
		}
		case 3 : {
			System.out.printf("\nminimum marks is %.2f",newMarks.minimum(number_of_students, marks));
			break;
		}
		case 4 : {
			System.out.println("\n total number of students passed"+newMarks.numOfStudentsPassed(number_of_students, marks));
			break;
		}
		default : {
			System.out.println("please enter a valid choice ");
		}
		}
	}

}

package ds2Counselling;

/**
 * This is main class for user to interact with
 */
public class MainCounseling {
	
	public static void main(String[] args) {
	        Counseling c = new Counseling();
	        c.allocatePrograms();
	        FileHandling.displayResult();
	        System.out.println("Result declared");
	}
}
package system;

/**
 * Elephant is the subclass of Mammal
 * It initializes the properties of Elephant when added to Zoo
 *
 */
public class Elephant extends Mammal{
	
	private static int id=1;
	
	public Elephant(int age,double weight) {
		super("Elephant"+(id+1), age, weight, "trumpet", 4, true,AnimalType.ELEPHANT);
	}
}

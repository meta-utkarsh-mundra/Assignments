package system;

/**
 * Lion is the subclass of Mammal
 * It initializes the properties of Lion when added to Zoo
 *
 */
public class Lion extends Mammal{
	private static int id = 1;

	/**
	 * This initializes Lion and calls its super to add it into Mammal
	 * @param age
	 * @param weight
	 */
	Lion(int age, double weight) {
		super("Lion"+(id+1), age, weight, "Roar", 4,true,AnimalType.LION);
	}
}

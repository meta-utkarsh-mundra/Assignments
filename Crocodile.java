package system;

/**
 * The Crocodile class is the subclass of the Reptile
 * It initializes the Crocodile animal when added to the Zoo
 *
 */
public class Crocodile extends Reptile {

	private static int id = 1;

	public Crocodile(int age, double weight) {
		super("Crocodile" + (id + 1), age, weight, "Grunts", 4, true,
				AnimalType.CROCODILE);
	}
}

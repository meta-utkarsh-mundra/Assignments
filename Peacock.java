package system;

/**
 * Peacock is the subclass of Bird
 * It initializes the properties of Peacock when added to Zoo
 *
 */
public class Peacock extends Bird{
	
	private static int id=1;

	/**
	 * This initializes Peacock and calls its super to add it into Bird
	 * @param age
	 * @param weight
	 */
	public Peacock(int age,double weight) {
		super("Peacock"+(id+1),age,weight,"scream",2,true,AnimalType.PEACOCK);
	}
}

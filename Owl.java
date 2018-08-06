package system;

/**
 * Owl is the subclass of Bird
 * It initializes the properties of Owl when added to Zoo
 *
 */
public class Owl extends Bird{
	
	private static int id=1;

	/**
	 * This initializes Owl and calls its super to add it into Bird
	 * @param age
	 * @param weight
	 */
	public Owl(int age,double weight) {
		super("Owl"+(id+1),age,weight,"Hoot",2,true,AnimalType.OWL);
	}
}

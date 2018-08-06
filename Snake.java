package system;

/**
 * Snake is the subclass of Reptile
 * It initializes the properties of Snake when added to Zoo
 *
 */
public class Snake extends Reptile{
	
	private static int id=1;

	/**
	 * This initializes Snake and calls its super to add it into Reptile
	 * @param age
	 * @param weight
	 */
	public Snake(int age,double weight) {
		super("Snake"+(id+1),age,weight,"Hiss",4,true,AnimalType.SNAKE);
	}
}

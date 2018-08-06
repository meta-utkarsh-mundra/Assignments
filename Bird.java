package system;

/**
 * This Bird class inherits the Animal super class
 *
 */
public class Bird extends Animal{
	
	private final boolean canFly;

	/**
	 * The constructor initializes the Birds in the Zoo
	 * It calls its superclass constructor to set it into animal property 
	 * @param name
	 * @param age
	 * @param weight
	 * @param sound
	 * @param noOfLegs
	 * @param canFly
	 * @param type
	 */
	public Bird(String name,int age, double weight,String sound, int noOfLegs,boolean canFly,AnimalType type) {
		
		super(name,age,weight,sound,noOfLegs,AnimalCategory.BIRD,type);
		this.canFly=canFly;
	}

	public boolean isCanFly() {
		return canFly;
	}
	
}

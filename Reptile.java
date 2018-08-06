package system;

/**
 * Reptile is the subclass of Animal and it adds the Reptile type animal into Zoo
 *
 */
public class Reptile extends Animal{
	
	private final boolean isColdBlood;

	/**
	 * This initializes the Reptile properties and calls super to add it into animal
	 * @param name
	 * @param age
	 * @param weight
	 * @param sound
	 * @param noOfLegs
	 * @param isColdBlood
	 * @param type
	 */
	public Reptile(String name,int age, double weight,String sound, int noOfLegs,boolean isColdBlood,AnimalType type) {
		
		super(name,age,weight,sound,noOfLegs,AnimalCategory.REPTILE,type);
		this.isColdBlood=isColdBlood;
	}

	public boolean isColdBlood() {
		return isColdBlood;
	}
}
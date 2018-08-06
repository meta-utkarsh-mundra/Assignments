package system;

/**
 * 
 * Mammals is the subclass of Animal and it adds the Mammal type animal into Zoo
 *
 */
public class Mammal extends Animal{
	
	private final boolean haveFur;

	/**
	 * This initializes the Mammals properties and calls super to add it into animal
	 * @param name
	 * @param age
	 * @param weight
	 * @param sound
	 * @param noOfLegs
	 * @param haveFur
	 * @param type
	 */
	public Mammal(String name,int age, double weight,String sound, int noOfLegs,boolean haveFur,AnimalType type) {
		
		super(name,age,weight,sound,noOfLegs,AnimalCategory.MAMMAL,type);
		this.haveFur=haveFur;
	}

	public boolean haveFur() {
		return haveFur;
	}
}
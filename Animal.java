package system;

/**
 * The Animal class is the superclass of many subclasses which generally shows
 * the properties of animal Here multiple properties are present for each animal
 *
 */
class Animal {
	private final String name;
	private int age;
	private double weight;
	private final String sound;
	private final int noOfLegs;
	private final AnimalCategory category;
	private final AnimalType type;

	/**
	 * This constructor initializes the animal via multiple properties
	 * 
	 * @param name
	 * @param age
	 * @param weight
	 * @param sound
	 * @param noOfLegs
	 * @param category
	 * @param type
	 */
	public Animal(String name, int age, double weight, String sound,
			int noOfLegs, AnimalCategory category, AnimalType type) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.sound = sound;
		this.noOfLegs = noOfLegs;
		this.category = category;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getWeight() {
		return weight;
	}

	public String getSound() {
		return sound;
	}

	public int getNoOfLegs() {
		return noOfLegs;
	}

	public AnimalCategory getCategory() {
		return category;
	}

	public AnimalType getType() {
		return type;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void showInfo() {
		System.out.println(name + "\t\t" + age + "\t\t" + weight + "\t\t"
				+ category + "\t\t" + type + "\t\t" + sound);
	}
}

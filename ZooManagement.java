package system;
import java.util.Scanner;

/**
 * This is the main method from where zoo management is begin
 *
 */
public class ZooManagement {
	public static void main(String[] args)
	{
		int choice, capacity, capacityOfCage;
		boolean hasPark, hasCanteen;
		AnimalCategory zoneType;
		AnimalType cageType, animalType, firstAnimalType;
		
		Zoo zoo = new Zoo(); // create object of zoo class
		
		// a while loop which is true for each situation
		while(true)
		{
			System.out.print("\nMENU!!!!\n1. Add Zone to the Zoo\n2. Add Cage to the Zone\n3. Add Animal to cage\n4. Remove animal from cage\n");
			System.out.print("Enter your choice..");
			Scanner input = new Scanner(System.in);
			choice = input.nextInt();
			
			switch (choice) // this switch case will show various operations of zoo class
			{
				case 1: zoneType = chooseZone(input);
						System.out.println("Please enter the capacity");
						capacity = input.nextInt();
						System.out.println("Does the zone has a park? (Enter true or false)");
						hasPark = input.nextBoolean();
						System.out.println("Does the zone has a canteen? (Enter true or false)");
						hasCanteen = input.nextBoolean();
			
						zoo.addZone(zoneType, capacity, hasPark, hasCanteen);
						break;
			
				case 2: cageType = chooseCage(input);
						System.out.println("Enter the capacity of the cage");
						capacityOfCage = input.nextInt();
		
						if(zoo.addCage(cageType, capacityOfCage))
							System.out.println("Cage is successfully added");
						break;
		    
				case 3: animalType = chooseCage(input);
			        	Animal animal = addNewAnimal(input, animalType);
			        	if(zoo.addAnimal(animal))
			        		System.out.println("Animal added successfully");
			        	break;
			
				case 4: firstAnimalType = chooseCage(input);
						if(zoo.removeAnimal(firstAnimalType))
							System.out.println("Remove successfully");
						break;
			}
		}
	}

	/**
	 * This will create a animal object to add animal
	 * @param input
	 * @param animalType
	 * @return animal object
	 */
	private static Animal addNewAnimal(Scanner input, AnimalType animalType)
	{	
		Animal animal = null;
		double weight, wingSpan;
		int age;
		
		switch(animalType)
		{
			case CROCODILE: System.out.println("Enter the weight and age of crocodile");
		     				weight = input.nextDouble();
		     				age = input.nextInt();
		     				animal = new Crocodile(age, weight);
		     				break;
			
			case ELEPHANT: System.out.println("Enter the weight and age of elephant");
	         			   weight = input.nextDouble();
	         			   age = input.nextInt();
	         			   animal = new Elephant(age, weight);
	         			   break;
			
			case LION: System.out.println("Enter the weight and age of Lion");
					   weight = input.nextDouble();
					   age = input.nextInt();
					   animal = new Lion(age, weight);
					   break;
			
			case OWL: System.out.println("Enter the weight, age and wing span of Parrot");
	         			 weight = input.nextDouble();
	         			 age = input.nextInt();
	         			 wingSpan = input.nextDouble();
	         			 animal = new Owl(age, weight);
	         			 break;
			
			case PEACOCK: System.out.println("Enter the weight, age and wing span of Peacock");
						  weight = input.nextDouble();
						  age = input.nextInt();
						  wingSpan = input.nextDouble();
						  animal = new Peacock(age, weight);
						  break;
			
			case SNAKE: System.out.println("Enter the weight and age of snake");
						weight = input.nextDouble();
						age = input.nextInt();
						animal = new Snake(age, weight);
						break;
		}
		return animal;
	}

	/**
	 * Used to find animal name
	 * @param input
	 * @return
	 */
	private static AnimalType chooseCage(Scanner input)
	{
		int cage;
		AnimalType cageType = null;
		
		System.out.print("\nList of Cage Types\n1. Lion\n2. Elephant\n3. Parrot\n4. Peacock\n5. Snake\n6. Crocodile\n");
	    System.out.print("Choose from the cage types..");
	    cage = input.nextInt();
	    
	    switch(cage)
	    {
	    	case 1: cageType = AnimalType.LION;
	    			break;
	    	case 2: cageType = AnimalType.ELEPHANT;
	    			break;
	    	case 3: cageType = AnimalType.OWL;
	    			break;
	    	case 4: cageType = AnimalType.PEACOCK;
	    			break;
	    	case 5: cageType = AnimalType.SNAKE;
	    			break;
	    	case 6: cageType = AnimalType.CROCODILE;
	    			break;
	    	default: System.out.println("No result found!!");
					 break;	
	    }
		return cageType;
	}

	private static AnimalCategory chooseZone(Scanner input)
	{	
		int zone;
		AnimalCategory zoneType = null;
		System.out.print("\nList of Zones\n1. Bird\n2. Mammal\n3. Reptile\n");
	    System.out.print("Choose from the zone types: ");
	    zone = input.nextInt();
	    switch (zone)
	    {
			case 1: zoneType = AnimalCategory.BIRD;
					break;
			case 2: zoneType = AnimalCategory.MAMMAL;
					break;
			case 3: zoneType = AnimalCategory.REPTILE;
					break;
			default: System.out.println("No result found!!");
					 break;
		}
		return zoneType;
	}
}
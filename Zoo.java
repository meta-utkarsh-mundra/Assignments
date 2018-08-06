package system;

import java.util.ArrayList;

/**
 * This class will perform various operations on Zoo management
 */
public class Zoo {
	ArrayList<Zone> listOfZone = new ArrayList<Zone>(); // create the list of zones
	
	/**
	 * This method add the zone for a specific type of animal
	 * @param zoneType
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public boolean addZone(AnimalCategory zoneType, int capacity, boolean hasPark, boolean hasCanteen) {
		Zone zone = null;
		
		switch(zoneType) {
			case BIRD: zone = new BirdZone(capacity, hasPark, hasCanteen);
					   break;
			case MAMMAL: zone = new MammalZone(capacity, hasPark, hasCanteen);
					     break;
			case REPTILE: zone = new ReptileZone(capacity, hasPark, hasCanteen);
						  break;		
		}
		listOfZone.add(zone);
		return true;
	}
	
	/**
	 * This method will add cage to a particular zone
	 * @param animal
	 * @return
	 */
	public boolean addCage(AnimalType animal, int capacity) {
		boolean flag = false;
		Cage cage = new Cage(animal, capacity);
		
		for(Zone zone: listOfZone) {
			if(zone.spareCapacity() != 0) {
				// check for a specific zone type and their animals
				if(zone.getZoneType() == AnimalCategory.BIRD && (animal.equals(AnimalType.OWL) || animal.equals(AnimalType.PEACOCK))) {
					zone.addCage(cage);
					flag = true;
					break;
				}
				else if(zone.getZoneType() == AnimalCategory.MAMMAL && (animal.equals(AnimalType.LION) || animal.equals(AnimalType.ELEPHANT))) {
					zone.addCage(cage);
					flag = true;
					break;
				}
				else if(zone.getZoneType() == AnimalCategory.REPTILE && (animal.equals(AnimalType.CROCODILE) || animal.equals(AnimalType.SNAKE))) {
					zone.addCage(cage);
					flag = true;
					break;
				}	
			}			
		}
		if(!flag)
			throw new AssertionError("You need to add a zone first!!");
		return flag;
	}
	
	/**
	 * This method adds the animal to a specific cage
	 * @param animal 
	 * @return true if added successfully
	 */
	public boolean addAnimal(Animal animal) {
		boolean flag = false;
		
		for(Zone zone: listOfZone) {
			if(zone.getZoneType().equals(animal.getCategory()) && zone.addAnimal(animal)) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
			throw new AssertionError("All zones are full!!You need to add a zone first!!");
		
		return flag;
	}
	
	/**
	 * This method removes the specific animal from the cage
	 * @param animal takes the animal name
	 */
	public boolean removeAnimal(AnimalType animal) {
		boolean flag = false;
		AnimalCategory category = null;
		
		switch(animal) {
			case CROCODILE: category = AnimalCategory.REPTILE;
							break;
			case ELEPHANT: category = AnimalCategory.MAMMAL;
						   break;
			case LION: category = AnimalCategory.MAMMAL;
					   break;
			case OWL: category = AnimalCategory.BIRD;
			             break;
			case PEACOCK: category = AnimalCategory.BIRD;
			              break;
			case SNAKE: category = AnimalCategory.REPTILE;
			            break;
		}
		
		for(Zone zone: listOfZone) {
			if(zone.getZoneType().equals(category) && zone.removeAnimal(animal)) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
			throw new AssertionError("Animal not found!");
		
		return flag;
	}
}

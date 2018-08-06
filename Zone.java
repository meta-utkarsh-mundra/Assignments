package system;

import java.util.ArrayList;
import java.util.List;

/**
 * Zone class will specifies the operations on the specified zone
 *
 */
public class Zone {

	private AnimalCategory zoneType;
	private final int capacity;
	private boolean canteen,park;
	private ArrayList<Cage> listOfCages = new ArrayList<>();

	/**
	 * This Zone constructor initializes the zone properties
	 * @param zoneType
	 * @param capacity
	 * @param hasPark
	 * @param hasCanteen
	 */
	public Zone(AnimalCategory zoneType, int capacity, boolean hasPark, boolean hasCanteen)
	{
		this.zoneType = zoneType;
		this.capacity = capacity;
		park = hasPark;
		canteen = hasCanteen;
	}

	public AnimalCategory getZoneType() {
		return zoneType;
	}

	public void setZoneType(AnimalCategory zoneType) {
		this.zoneType = zoneType;
	}

	public boolean isHasPark() {
		return park;
	}

	public void setHasPark(boolean hasPark) {
		this.park = hasPark;
	}

	public boolean isHasCanteen() {
		return canteen;
	}

	public void setHasCanteen(boolean hasCanteen) {
		this.canteen = hasCanteen;
	}

	public ArrayList<Cage> getNoOfCages()
	{
		return listOfCages;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int spareCapacity() {
		return capacity - listOfCages.size();
	}
	
	/**
	 * The addCage method add the cage for a specific zone
	 * @param cage
	 */
	public void addCage(Cage cage)
	{
		if(spareCapacity() != 0)
			listOfCages.add(cage);
		else
			throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
	}
	
	/**
	 * This method will add animal to a specific cage
	 * @param animal
	 * @return true if animal added successfully
	 */
	public boolean addAnimal(Animal animal)
	{
		boolean flag = false;
		
		for(Cage cage: listOfCages)
		{
			if(cage.getAnimalType().equals(animal.getType()) && cage.spareCapacity() != 0)
			{
				flag = true;
				cage.addAnimal(animal);
				break;
			}	
		 }
		if(!flag)
			throw new AssertionError("Capacity of the zone is full! Cannot add animal!");
		
		return flag;
	}
	
	/**
	 * This method will remove the animal from specific cage
	 * @param animal
	 * @return true if remove successfully
	 */
	public boolean removeAnimal(AnimalType animal)
	{
		boolean removed = false;
		
		for(Cage cage: listOfCages)
		{
			if(cage.getAnimalType().equals(animal))
				removed = cage.removeAnimal();
		}	
		return removed;
	}
}
package system;

/**
 * This class inherits the Zone class and used to add Bird Zone in the Zoo
 *
 */
public class BirdZone extends Zone{
	
	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen) {
		
		super(AnimalCategory.BIRD, capacity, hasPark, hasCanteen);
	}
}
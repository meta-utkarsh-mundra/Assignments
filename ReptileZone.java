package system;

/**
 *  This class will add the Reptile zone into Zoo
 *
 */
public class ReptileZone extends Zone{

	public ReptileZone(int capacity, boolean hasPark, boolean hasCanteen) {
		
		super(AnimalCategory.REPTILE, capacity, hasPark, hasCanteen);
	}
}
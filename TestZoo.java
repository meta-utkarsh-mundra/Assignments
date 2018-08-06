package system;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *To test different methods of Zoo
 *
 */
public class TestZoo
{
	Zoo zoo = new Zoo();
	
	/**
     * test for adding zones in the zoo
     */
    @Test
    public void addZoneTest()
    {    
        assertTrue(zoo.addZone(AnimalCategory.MAMMAL, 2, true, true));
        assertTrue(zoo.addZone(AnimalCategory.BIRD, 2, false, true));
        assertTrue(zoo.addZone(AnimalCategory.REPTILE, 2, false, false));
        assertTrue(zoo.addZone(AnimalCategory.BIRD, 2, false, true));
    }
    
    /**
     * test for adding cage in the zoo when compatible zone is present
     */
    @Test
    public void firstAddCageTest()
    {
        zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
        assertTrue(zoo.addCage(AnimalType.LION, 3));
    }
    
    /**
     * test for adding cage in the zoo when compatible zone is not present
     */
    @Test(expected = AssertionError.class)
    public void secondAddCageTest()
    {
        zoo.addZone(AnimalCategory.BIRD, 2, true, true);
        zoo.addCage(AnimalType.LION, 3);
    }
    
    /**
     * test for adding cages in the zoo exceeding the capacity of the zone
     */
    @Test(expected = AssertionError.class)
    public void thirdAddCageTest()
    {
        zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
        zoo.addCage(AnimalType.LION, 3);
        zoo.addCage(AnimalType.LION, 3);
        zoo.addCage(AnimalType.LION, 3); //adding the third cage when capacity of zone is two
    }
    
    /**
     * test for adding an animal(lion in this case) in the zoo when compatible cage is present
     */
    @Test
    public void firstAddAnimalTest()
    {
        zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
        zoo.addCage(AnimalType.LION, 3);
        assertTrue(zoo.addAnimal(new Lion(25, 12)));
    }
    
    /**
     * test for adding an animal(lion in this case) in the zoo when compatible cage is not present
     */
    @Test(expected = AssertionError.class)
    public void secondAddAnimalTest()
    {
        zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
        zoo.addCage(AnimalType.ELEPHANT, 3);
        assertTrue(zoo.addAnimal(new Lion(25, 12)));
    }
    
    /**
     * test for adding animals(elephant in this case) in the zoo exceeding the capacity of the cage
     */
    @Test(expected = AssertionError.class)
    public void thirdAddAnimalTest()
    {
        zoo.addZone(AnimalCategory.MAMMAL, 2, true, true);
        zoo.addCage(AnimalType.ELEPHANT, 3);
        zoo.addAnimal(new Elephant(250, 12));
        zoo.addAnimal(new Elephant(180, 10));
        zoo.addAnimal(new Elephant(25, 2));
        zoo.addAnimal(new Elephant(25, 2)); //adding the fourth elephant when capacity of cage is three
    }
}

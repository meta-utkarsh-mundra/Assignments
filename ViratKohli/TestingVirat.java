package ViratKohli;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Before;

public class TestingVirat {

	HashMap<String, Integer> bowlers;
	
	/**
	 * this test case is used to  create and initialize the bowler map
	 */
	@Before
	public void initializeObj() {
		bowlers = new LinkedHashMap<String, Integer>();
		bowlers.put("Ajay", 7);
		bowlers.put("Sankalp", 9);
		bowlers.put("Utkarsh", 5);
	}

	
	/**
	 * test case for testing the bowling order returned by the Virat() method
	 */
	@Test
	public void ViratTest1() {
		Virat Virat = new Virat(10, bowlers);
		List<String> expectedBowlingOrder = new ArrayList<String>(){{
												add("Sankalp");
												add("Sankalp");
												add("Ajay");
												add("Sankalp");
												add("Ajay");
												add("Sankalp");
												add("Ajay");
												add("Sankalp");
												add("Utkarsh");
												add("Ajay");
		                                    }};
		assertEquals(expectedBowlingOrder, Virat.bowlingOrder());
	}
	
	
	/**
	 * test case when no of balls that virat would play is greater than the number of balls the bowlers can bowl combined
	 */
	@Test(expected = AssertionError.class)
	public void ViratTest2() {
		
		new Virat(40, bowlers);
	}
	
	
	/**
     * test case when no of balls that virat would play is negative
     */
    @Test(expected = AssertionError.class)
    public void ViratTest4() {
        
        new Virat(-20, bowlers);
    }
    
    
    /**
     * test case when no of balls that virat would play is 0
     */
    @Test(expected = AssertionError.class)
    public void ViratTest5() {
        
        new Virat(0, bowlers);
    }
    
    
    /**
     * test case when no of balls to be bowled by a bowler is negative
     */
    @Test(expected = AssertionError.class)
    public void ViratTest6() {
        
        HashMap<String, Integer> newBowlerHashMap = new LinkedHashMap<String, Integer>();
        
        newBowlerHashMap.put("Ajay", 7);
        newBowlerHashMap.put("Sankalp", 9);
        newBowlerHashMap.put("Utkarsh", -2);
        new Virat(10, newBowlerHashMap);
    }
}
package Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
public class TestUnit {
	MaxMirror mirror_object = new MaxMirror();
	CalculateClumps clumps_object = new CalculateClumps();
	CalculateFixxy fixxy_object = new CalculateFixxy();
	CheckSplitPoint split_array_object = new CheckSplitPoint();
	
	/**
	 * first test case for maximum mirror
	 */
	@org.junit.Test
	public void mirrorTestOne() {
		int count = mirror_object.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
		assertEquals(3, count);
	}
	
	/**
	 * second test case for maximum mirror
	 */
	@org.junit.Test
	public void mirrorTestTwo() {
		int count = mirror_object.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1});
		assertEquals(7, count);
	}
	
	/**third test case for maximum mirror
	 * to check if its empty 
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void mirrorTestThree() {
		int count = mirror_object.maxMirror(new int[]{});
	}
	
	/**
	 * first test case for clumps
	 */
	@org.junit.Test
	public void clumpsTestOne() {
		int count = clumps_object.totalClumps(new int[]{1, 2, 2, 3, 4, 4});
		assertEquals(2, count);
	}
	
	/**
	 * second test case for clumps
	 */
	@org.junit.Test
	public void clumpsTestTwo() {
		int count = clumps_object.totalClumps(new int[]{1, 1, 1, 1, 1});
		assertEquals(1, count);
	}
	
	/**
	 * third test case for clumps to check
	 * for an empty array
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void clumpsTestThree() {
		int count = clumps_object.totalClumps(new int[]{});
	}
	
	/**
	 * first test case for fixXY
	 */
	@org.junit.Test
	public void fixxyTestOne()  {
		int[] result = fixxy_object.fixXy(4, 5, new int[]{5, 4, 9, 4, 9, 5});
		assertArrayEquals(new int[]{9, 4, 5, 4, 5, 9}, result);
	}
	
	/**
	 * second test case for fixXy
	 */
	@org.junit.Test
	public void fixxyTestTwo() {
		int[] result = fixxy_object.fixXy(4, 5, new int[]{1, 4, 1, 5});
		assertArrayEquals(new int[]{1, 4, 5, 1}, result);
	}
	
	/**
	 * third test case for fixxy to check 
	 * if the array is empty
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void fixxyTestThree() {
		int[] result = fixxy_object.fixXy(4, 5, new int[]{});
	}
	
	/**
	 * fourth test case for fixxy to check if 
	 * there are unequal x and y
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void fixxyTestFour() {
		int[] result = fixxy_object.fixXy(4, 5, new int[]{1, 4, 3, 5, 5});
	}
	
	/**
	 * fifth test case for fixxy to chech
	 * if x is on the last position
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void fixxyTestFive() {
		int[] result = fixxy_object.fixXy(4, 5, new int[]{1, 4, 3, 5, 5, 4});
	}
	
	/**
	 * first test case for split array
	 */
	@org.junit.Test
	public void splitTestOne() {
		int result = split_array_object.splitPoint(new int[]{1, 1, 1, 2, 1});
		assertEquals(3, result);
	}
	
	/**
	 * second test case for split array
	 */
	@org.junit.Test
	public void splitTestTwo() {
		int result = split_array_object.splitPoint(new int[]{2, 1, 1, 2, 1});
		assertEquals(-1, result);
	}
	
	/**
	 * third test case for split array to 
	 * check if the array is empty
	 */
	@org.junit.Test(expected = AssertionError.class)
	public void splitTestThree() {
		int result = split_array_object.splitPoint(new int[]{});
	}
}

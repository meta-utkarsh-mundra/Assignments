package Assignment5.LCMHCF;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcmHcfTest {

	@Test
	public void testCalculateHcf() {
		LcmHcf object = new LcmHcf();
		int first = 18;
		int second = 45;
		assertEquals(9, object.calculateHcf(first, second));
		
		first = 2;
		second = 45;
		assertEquals(1, object.calculateHcf(first, second));
		
		first = 8;
		second = 12;
		assertEquals(4, object.calculateHcf(first, second));
		
		first = 18;
		second = 84;
		assertEquals(6, object.calculateHcf(first, second));
		
		first = -50;
		second = -100;
		assertEquals(50, object.calculateHcf(first, second));
		
	}

	/*@Test
	public void testCalculateLcm() {
		fail("Not yet implemented");
	}*/

}

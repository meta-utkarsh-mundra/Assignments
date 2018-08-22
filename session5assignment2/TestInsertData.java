package session5assignment2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestInsertData {

	List<ImageData> listOfObjects = new ArrayList<ImageData>();

	@Before
	public void initaliseListOfObjects() {
		listOfObjects.add(new ImageData(1, "xyzx"));
		listOfObjects.add(new ImageData(2, "abc"));
		listOfObjects.add(new ImageData(3, "pqr"));
		listOfObjects.add(new ImageData(4, "lmn"));
		listOfObjects.add(new ImageData(5, "zzz"));
	}

	@Test
	public void testImageDataInsertionChecking() {
		assertEquals(true, InsertImageData.inserImageData(listOfObjects, 6));
	}
}
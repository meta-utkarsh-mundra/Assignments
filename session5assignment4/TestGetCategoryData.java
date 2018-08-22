package session5assignment4;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestGetCategoryData {
	private List<Category> listOfResultCategory;

	@Before
	public void initialiseList() {
		listOfResultCategory = GetCategoryData.getCategoryData();
	}

	@Test
	public void testForFirstChild() {
		int childOfLarge = listOfResultCategory.get(0).getTotalChilds();
		assertEquals("total 2 childs of large", 2, childOfLarge);
	}

	@Test
	public void testForSecondChild() {
		List<Category> list = GetCategoryData.getCategoryData();
		int childOfMedium = list.get(1).getTotalChilds();
		assertEquals(3, childOfMedium);
	}
}
package testcase;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import logic.Sorting;
import static org.junit.Assert.assertEquals;

public class TestCase2 {

	static int[] arr = new int[3];

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Setting Data");
		arr[0] = 5;
		arr[1] = 8;
		arr[2] = 2;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Sorting Data");
		Sorting.sort(arr);
	}

	@Test
	public void checkMax() throws Exception {
		System.out.println("Checking Max");
		assertEquals(8, Sorting.max(arr));
	}

	@Test
	public void checkMin() throws Exception {
		System.out.println("Checking Min");
		assertEquals(2, Sorting.min(arr));
	}

}

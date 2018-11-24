package testcase;

import logic.Calculation;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class TestCase1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass Running");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before each method");
	}

	@Test
	public void testCube() {
		System.out.println("Test Case Cube");
		assertEquals(27, Calculation.Cube(3));
	}

	@Test
	public void testArea() {
		System.out.println("Test Case Area");
		assertEquals(600, Calculation.Area(20, 30));
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After Method");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass Running");
	}

}

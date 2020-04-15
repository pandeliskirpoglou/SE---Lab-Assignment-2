package math;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.MyMath; 

public class MyMathTest {

	/*
	 * A unit test that checks if the illegal argument exception for negative number
	 * given is thrown correctly
	 */
	MyMath mm = new MyMath();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testForNumberBeloZero() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number should be 0 or above and 12 or below");
		mm.factorial(-1);
	}

	/*
	 * A unit test that checks if the illegal argument exception for numbers greater
	 * than 12 is thrown correctly
	 */

	@Test
	public void testForNumberGreaterThanLimit() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number should be 0 or above and 12 or below");
		mm.factorial(13);
	}

}

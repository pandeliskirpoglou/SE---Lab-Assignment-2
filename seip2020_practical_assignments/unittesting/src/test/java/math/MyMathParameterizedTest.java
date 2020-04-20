package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import math.MyMath;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * A test class that implements a Parameterized test for the MyMath factorial
 * method,
 * 
 * @author pandeliskirpoglou
 */

@RunWith(Parameterized.class)
public class MyMathParameterizedTest {

	@Parameter(0)
	public int number;
	@Parameter(1)
	public int result;

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 0, 1 }, { 1, 1 }, { 2, 2 }, { 12, 479001600 } };

		return Arrays.asList(data);
	}

	MyMath mm = new MyMath();

	/*
	 * A unit test that checks for the correct results of the method factorial
	 */

	@Test
	public void testResultsOfFactorial() {
		Assert.assertEquals(result, mm.factorial(number), 0.0001);

	}

}

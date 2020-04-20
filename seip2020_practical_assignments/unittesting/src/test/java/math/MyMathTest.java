package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import math.MyMath;

/**
 * A class that provides test cases for the MyMath class.
 * 
 * @author pandeliskirpoglou (pand181567@yahoo.com)
 */

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

	/*
	 * A unit test that checks if the result of the method factorial is correct
	 * (asked for separate test cases)
	 */

	@Test
	public void testResultsOfFactorialMethod() {
		Assert.assertEquals(6, mm.factorial(3), 0.0001);
	}

	/*
	 * A unit test that checks if the illegal argument for number below 2 is thrown
	 * correctly
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testIsPrimeBelowTwo() {
		mm.isPrime(0);
	}

	/*
	 * A unit test that checks result for a prime number
	 */

	@Test
	public void testIsPrimePositiveResults() {
		Assert.assertEquals(true, mm.isPrime(2));
	}

	/*
	 * A unit test that checks result for a number which is not prime
	 */

	@Test
	public void testIsPrimeNegativeResults() {
		Assert.assertEquals(false, mm.isPrime(6));
	}

}

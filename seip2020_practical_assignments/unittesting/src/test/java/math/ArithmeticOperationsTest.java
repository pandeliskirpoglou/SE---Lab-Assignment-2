package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;
import math.ArithmeticOperations;

/**
 * A class that provides test cases for the arithmetic operations of the
 * ArithmeticOperations class.
 * 
 * @author pandeliskirpoglou (pand181567@yahoo.com)
 */

public class ArithmeticOperationsTest {

	ArithmeticOperations ao = new ArithmeticOperations();

	/*
	 * A unit test that checks if the results of divide are correct
	 */
	@Test
	public void testResultsForDivide() {
		Assert.assertEquals(2.0, ao.divide(2.6, 1.3), 0.0001);
	}
  
	/*
	 * A unit test that checks if the illegal argument exception is thrown correctly
	 */
	@Test(expected = ArithmeticException.class)
	public void testCauseDenominatorException() {
		ao.divide(1, 0);
	}

	/*
	 * A unit test that checks if the results of multiply are correct
	 */
	@Test
	public void testResultsForMultiply() {
		Assert.assertEquals(8, ao.multiply(4, 2), 0.0001);
	}

	/*
	 * A unit test that checks if the illegal argument exception for negative X
	 * parameter is thrown correctly
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNegativeXException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(-2, 4);
	}

	/*
	 * A unit test that checks if the illegal argument exception for negative Y
	 * parameter is thrown correctly
	 */

	@Test
	public void testNegativeYException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		ao.multiply(2, -4);
	}

	/*
	 * A unit test that checks if the illegal argument exception for MAXVALUE is
	 * thrown correctly
	 */

	@Test
	public void testMaxValueException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(9999999, 9999999);
	}

}

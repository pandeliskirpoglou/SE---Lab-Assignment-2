package math;

/**
 * The MyMath provides simple methods such as computing a factorial
 *
 * @author pandeliskirpoglou
 * @version 1.0
 * @since 2020-04-15
 */

public class MyMath {

	/**
	 * Gets one integer and returns it's factorial.
	 * 
	 * @param n the number of which we want the factorial
	 * @return fact the factorial of the number n
	 * @exception IllegalArgumentException when inputs n < 0 and n > 12
	 */

	public int factorial(int n) {
		int fact = 1;
		if (n < 0 || n > 12) {
			throw new IllegalArgumentException("number should be 0 or above and 12 or below");
		} else {
			for (int i = 1; i <= n; i++) {
				fact = fact * i;
			}
		}

		return fact;
	}

}

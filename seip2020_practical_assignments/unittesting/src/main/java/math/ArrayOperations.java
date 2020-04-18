package math;

import java.util.Arrays;

import io.FileIO;

/**
 * The MyMath provides simple methods such as computing a factorial or finding
 * whether an integer is prime
 *
 * @author pandeliskirpoglou
 * @version 1.0
 * @since 2020-04-18
 */

public class ArrayOperations {

	/**
	 * Gets one integer and returns true if it is prime and false if it is not.
	 * 
	 * @param fileio   instance for reading a file
	 * @param filepath path for file that needs to be checked
	 * @param myMath   instance for checking whether a number is prime
	 * @return arrayOfPrimeNumbers the array of prime numbers that where in the file
	 */

	public int[] findPrimesInFile(FileIO fileio, String filepath, MyMath myMath) {
		int[] arrayOfNumbers = fileio.readFile(filepath);
		int[] arrayOfPrimeNumbers = {};
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			if (myMath.isPrime(arrayOfNumbers[i])) {
				arrayOfPrimeNumbers = Arrays.copyOf(arrayOfPrimeNumbers, arrayOfPrimeNumbers.length + 1);
				// Extending the length of arrayOfPrimeNumbers by one to add the new prime
				// number
				arrayOfPrimeNumbers[arrayOfPrimeNumbers.length - 1] = arrayOfNumbers[i];
				// Adding the new prime number

			}
		}
		return arrayOfPrimeNumbers;
	}

}

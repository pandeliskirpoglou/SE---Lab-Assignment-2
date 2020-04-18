package math;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import io.FileIO;
import math.ArrayOperations;
import math.MyMath;

/**
 * A class that provides test cases for the arithmetic operations of the
 * ArrayOperations class with mocks for FileIO and MyMath
 * 
 * @author pandeliskirpoglou (pand181567@yahoo.com)
 */

public class ArrayOperationsTest {

	/*
	 * A unit test that checks if the results of finding prime numbers in a file
	 */

	ArrayOperations ao = new ArrayOperations();

	@Test
	public void testFindPrimesInFileResults() {
		FileIO fileio = mock(FileIO.class);
		MyMath myMath = mock(MyMath.class);
		int[] testValues = { 2, 3, 4, 5, 6 };

		when(fileio.readFile("filepath")).thenReturn(testValues);
		when(myMath.isPrime(2)).thenReturn(true);
		when(myMath.isPrime(3)).thenReturn(true);
		when(myMath.isPrime(4)).thenReturn(false);
		when(myMath.isPrime(5)).thenReturn(true);
		when(myMath.isPrime(6)).thenReturn(false);

		Assert.assertArrayEquals(new int[] { 2, 3, 5 }, ao.findPrimesInFile(fileio, "filepath", myMath));
		// filepath does not matter

	}

}

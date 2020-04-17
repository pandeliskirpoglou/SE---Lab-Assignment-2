package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import io.FileIO;

/**
 * A class that provides test cases for the FileIO class.
 * 
 * @author pandeliskirpoglou (pand181567@yahoo.com)
 */

public class FileIOTest {

	FileIO fileio = new FileIO();
	public static String path = "src/test/resources/";

	/*
	 * A unit test that tests whether a file of numbers is being read correctly
	 */

	@Test
	public void testReadFile() {
		int[] expectedNumbers = new int[] { 3, 9, 0, 2, 10, 9, 3, 8, 0, 3 };
		String validPath = path.concat("grades_valid.txt");

		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validPath));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/*
	 * A unit test that tests illegal argument exception for invalid path
	 */

	@Test
	public void testReadFileNotFound() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		fileio.readFile("invalidPath");
	}

	/*
	 * A unit test that tests illegal argument exception for invalid path
	 */

	@Test
	public void testReadFileEmptyFileInput() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		String emptyFilePath = path.concat("empty_file.txt");
		fileio.readFile(emptyFilePath);
	}
	
	@Test 
	public void testReadFileContainsInvalidEntries() {
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("Grades should be integers");
		String emptyFilePath = path.concat("grades_invalid.txt");
		fileio.readFile(emptyFilePath);
	}
	
}

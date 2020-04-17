package io;

import org.junit.Assert;
import org.junit.Test;
import io.FileIO;

public class FileIOTest {

	FileIO fileio = new FileIO();
	public static String path = "src/test/resources";

	@Test
	public void testReadFile() {
		String[] expectedNumbers = new String[] { "3", "9", "0", "2", "10", "9", "3", "8", "0", "3" };
		String validPath = path.concat("grades.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validPath));
	}

}

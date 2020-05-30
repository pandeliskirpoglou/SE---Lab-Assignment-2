package codeanalyzer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class WebTest {

	FileLocation sfr = new Web();
	private static List<String> expectedList;
	private static String expectedString;
	private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";

	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File("src/test/resources/TestClass.java").toPath(), Charset.defaultCharset());
		expectedString = String.join("\n", expectedList) + "\n"; // transforms a list into a String (with 'new line' as
																	// delimiter)
	}

	@Test
	public void testReadFileIntoListWeb() {
		// read a file stored in the web into a List
		List<String> actualList = sfr.readFileIntoList(TEST_CLASS_WEB);

		String[] expecteds = expectedList.stream().toArray(String[]::new);
		String[] actuals = actualList.stream().toArray(String[]::new);

		assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void testReadFileIntoStringWeb() throws IOException {
		//read a file stored in the web into a String
		String actuals = sfr.readFileIntoString(TEST_CLASS_WEB);
				
		assertEquals(expectedString, actuals);
	}

}

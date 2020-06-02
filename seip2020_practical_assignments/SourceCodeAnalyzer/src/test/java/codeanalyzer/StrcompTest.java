package codeanalyzer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class StrcompTest {

	private static List<String> expectedList;
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String TEST_CLASS_EMPTY = "src/test/resources/empty_file.txt";
	private final static String TEST_CLASS_WEB = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private final static String TEST_CLASS_EMPTY_WEB = "https://drive.google.com/u/0/uc?id=1PnRzgjlC_alg3Ff885iHszjTHLR1wzRy&export=download";
	/*
	 * Link for empty web file was uploaded and got the link for the download
	 */
	private AnalyzerType sca = new Strcomp();	
	private static FileLocation flLocal = mock(Local.class);
	private static FileLocation flWeb = mock(Web.class);

	@BeforeClass
	public static void setUp() throws IOException {
		expectedList = Files.readAllLines(new File(TEST_CLASS).toPath(), Charset.defaultCharset());
		List<String> emptyList = new ArrayList<>();

		when(flLocal.readFileIntoList(TEST_CLASS)).thenReturn(expectedList);
		when(flWeb.readFileIntoList(TEST_CLASS_WEB)).thenReturn(expectedList);
		when(flLocal.readFileIntoList(TEST_CLASS_EMPTY)).thenReturn(emptyList);
		when(flWeb.readFileIntoList(TEST_CLASS_EMPTY_WEB)).thenReturn(emptyList);

	}

	@Test
	public void testCalculateLocForLocal() {
		assertEquals(7, sca.calculateLOC(flLocal, TEST_CLASS));
	}

	@Test
	public void testCalculateLocForWeb() {
		assertEquals(7, sca.calculateLOC(flWeb, TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateLocForLocalEmptyFile() {
		assertEquals(0, sca.calculateLOC(flLocal, TEST_CLASS_EMPTY));
	}

	@Test
	public void testCalculateLocForWebEmptyFile() {
		assertEquals(0, sca.calculateLOC(flWeb, TEST_CLASS_EMPTY_WEB));
	}

	@Test
	public void testCalculateNocLocal() throws IOException {
		assertEquals(3, sca.calculateNOC(flLocal, TEST_CLASS));
	}

	@Test
	public void testCalculateNocWeb() throws IOException {
		assertEquals(3, sca.calculateNOC(flWeb, TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateNocForLocalEmptyFile() {
		assertEquals(0, sca.calculateNOC(flLocal, TEST_CLASS_EMPTY));
	}

	@Test
	public void testCalculateNocForWebEmptyFile() {
		assertEquals(0, sca.calculateNOC(flWeb, TEST_CLASS_EMPTY_WEB));
	}

	@Test
	public void testCalculateNomLocal() throws IOException {
		assertEquals(3, sca.calculateNOM(flLocal, TEST_CLASS));
	}

	@Test
	public void testCalculateNomWeb() throws IOException {
		assertEquals(3, sca.calculateNOM(flWeb, TEST_CLASS_WEB));
	}

	@Test
	public void testCalculateNomForLocalEmptyFile() {
		assertEquals(0, sca.calculateNOM(flLocal, TEST_CLASS_EMPTY));
	}

	@Test
	public void testCalculateNomForWebEmptyFile() {
		assertEquals(0, sca.calculateNOM(flWeb, TEST_CLASS_EMPTY_WEB));
	}

}

package codeanalyzer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

public class NOMTest {

	private static AnalyzerType at = mock(Regex.class);
	private static FileLocation fl = mock(Local.class);
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	/*
	 * Does not matter what types of file location and analyzer type we choose
	 * because they are mocks and they are going to have mocked results
	 */
	
	@BeforeClass
	public static void setUp() throws IOException {
		when(at.calculateNOM(fl, TEST_CLASS)).thenReturn(3);
	}
	
	@Test
	public void testNocConstructor() {
		Metric nom = new NOM(at, fl, TEST_CLASS);
		assertTrue(nom.analyzerType instanceof Regex);
	}
	
	@Test
	public void testCalculateMetricNom() {
		Metric nom = new NOM(at, fl, TEST_CLASS);
		assertEquals(3, nom.calculateMetric());
	}

}

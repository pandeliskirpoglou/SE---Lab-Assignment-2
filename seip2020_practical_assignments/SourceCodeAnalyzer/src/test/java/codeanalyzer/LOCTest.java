package codeanalyzer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import org.junit.BeforeClass;
import org.junit.Test;

public class LOCTest {

	private static AnalyzerType at = mock(Regex.class);
	private static FileLocation fl = mock(Local.class);
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";

	/*
	 * Does not matter what types of file location and analyzer type we choose
	 * because they are mocks and they are going to have mocked results
	 */

	@BeforeClass
	public static void setUp() throws IOException {
		when(at.calculateLOC(fl, TEST_CLASS)).thenReturn(21);
		when(at.calculateNOC(fl, TEST_CLASS)).thenReturn(3);
		when(at.calculateNOM(fl, TEST_CLASS)).thenReturn(3);
	}

	@Test
	public void testLocConstructor() {
		Metric loc = new LOC(at, fl, TEST_CLASS);
		assertTrue(loc.analyzerType instanceof Regex);
	}

	@Test
	public void testCalculateMetricLoc() {
		Metric loc = new LOC(at, fl, TEST_CLASS);
		assertEquals(21, loc.calculateMetric());
	}

}

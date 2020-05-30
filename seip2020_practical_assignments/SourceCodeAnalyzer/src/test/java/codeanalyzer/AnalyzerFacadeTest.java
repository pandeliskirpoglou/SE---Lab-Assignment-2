package codeanalyzer;

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

public class AnalyzerFacadeTest {

	private static AnalyzerFacade af = new AnalyzerFacade();
	private static String filepathLocal = "src/test/resources/TestClass.java";
	private static String filepathWeb = "https://drive.google.com/uc?export=download&id=1z51FZXqPyun4oeB7ERFlOgfcoDfLLLhg";
	private static Map<String, Integer> expectedMetricsForRegex = new HashMap<>();
	private static Map<String, Integer> expectedMetricsForStrcomp = new HashMap<>();

	/*
	 * No need to test for empty files because they have been already checked in the
	 * File Readers
	 */

	@BeforeClass
	public static void setUp() {

		expectedMetricsForRegex.put("loc", 21);
		expectedMetricsForRegex.put("nom", 3);
		expectedMetricsForRegex.put("noc", 3);

		expectedMetricsForStrcomp.put("loc", 7);
		expectedMetricsForStrcomp.put("nom", 3);
		expectedMetricsForStrcomp.put("noc", 3);

	}

	@Test
	public void testCalculateMetricsWithRegexLocal() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathLocal, "local", "regex");
		assertEquals(expectedMetricsForRegex, resultMetrics);

	}

	@Test
	public void testCalculateMetricsWithRegexWeb() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathWeb, "web", "regex");
		assertEquals(expectedMetricsForRegex, resultMetrics);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateMetricsWithRegexNoFileLocation() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathLocal, "wrong_location", "regex");
	}
	
	@Test
	public void testCalculateMetricsWithStrcompLocal() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathLocal, "local", "strcomp");
		assertEquals(expectedMetricsForStrcomp, resultMetrics);

	}

	@Test
	public void testCalculateMetricsWithStrcompWeb() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathWeb, "web", "strcomp");
		assertEquals(expectedMetricsForStrcomp, resultMetrics);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateMetricsWithStrcompNoFileLocation() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathLocal, "wrong_location", "strcomp");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCalculateMetricsWithNoanalyzerType() {
		Map<String, Integer> resultMetrics = af.calculateMetrics(filepathLocal, "does_not_matter", "wrong_type");
	}


}

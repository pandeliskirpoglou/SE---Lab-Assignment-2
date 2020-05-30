package codeanalyzer;

import static org.junit.Assert.*;
import org.junit.Test;


public class MetricsExporterFactoryTest {

	MetricsExporterFactory mef = new MetricsExporterFactory();

	@Test
	public void testReturnTypeCSV() {
		MetricsExporter me = mef.createMetricsExporter("csv");
		assertTrue(me instanceof CSVExporter);
	}

	@Test
	public void testReturnTypeJSON() {
		MetricsExporter me = mef.createMetricsExporter("json");
		assertTrue(me instanceof JSONExporter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCauseIllegalArguementException() {
		MetricsExporter me = mef.createMetricsExporter("notype");
	}
}

package codeanalyzer;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class CSVExporterTest {

	MetricsExporter mex = new CSVExporter();
	
	@Test
	public void testWriteCsvFile() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.writeFile(metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}

}

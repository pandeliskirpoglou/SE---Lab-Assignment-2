package codeanalyzer;

import java.util.Map;

/**
 * Exports (writes) the metrics to a JSON file.
 * 
 * @author agkortzis 
 * @author pandeliskirpoglou
 */

public class JSONExporter implements MetricsExporter {
	
	/**
	 * Exports file in to JSON type
	 * 
	 * @param filepath the filepath that the file will be exported to
	 * @param metrics  the metrics that will be exported in the file
	 */

	@Override
	public void writeFile(Map<String, Integer> metrics, String filepath) {
		// TODO Add functionality for json writer

	}

}

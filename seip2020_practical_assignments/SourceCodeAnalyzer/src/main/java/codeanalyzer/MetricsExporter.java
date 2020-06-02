package codeanalyzer;

import java.util.Map;

/**
 * This interface lets you export a file type of your preference.
 * 
 * @author pandeliskirpoglou
 *
 */

public interface MetricsExporter {

	/**
	 * Exports file in to whatever type is asked
	 * 
	 * @param filepath the filepath that the file will be exported to
	 * @param metrics  the metrics that will be exported in the file
	 */

	public void writeFile(Map<String, Integer> metrics, String filepath);

}

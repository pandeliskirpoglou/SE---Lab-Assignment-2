package codeanalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * This class instantiates the appropriate metrics with the appropriate file
 * locations and analyzer types. It is used as a simple interface for the client
 * with only one method.
 * 
 * @author pandeliskirpoglou
 *
 */

public class AnalyzerFacade {

	/**
	 * Calculates the metrics of the file given
	 * 
	 * @param filepath     the filepath of the file that we want to examine
	 * @param fileLocation the location of a file (<b>local</b> for locally stored
	 *                     files, <b>web</b> for files stored on the web).
	 * @param analyzerType the type of analyzation (<b>regex</b>, <b>strcomp</b>).
	 * 
	 * @return calcMetrics a HashMap with the names and the values of the calculated
	 *         metrics.
	 */

	public Map<String, Integer> calculateMetrics(String filepath, String fileLocation, String analyzerType) {
		Map<String, Integer> calcMetrics = new HashMap<>();
		
		AnalyzerType at = null;
		FileLocation fl = null;
		
		
		if (analyzerType.equals("regex")) {
			at = new Regex();
		} else if (analyzerType.equals("strcomp")) {
			at = new Strcomp();
		} else {
			throw new IllegalArgumentException("Unknown type : " + analyzerType);
		}

		if (fileLocation.equals("local")) {
			fl = new Local();
		} else if (fileLocation.equals("web")) {
			fl = new Web();
		} else {
			throw new IllegalArgumentException("Unknown type : " + fileLocation);
		}
		
		Metric loc = new LOC(at, fl, filepath);
		Metric nom = new NOM(at, fl, filepath);
		Metric noc = new NOC(at, fl, filepath);

		calcMetrics.put("loc", loc.calculateMetric());
		calcMetrics.put("nom", nom.calculateMetric());
		calcMetrics.put("noc", noc.calculateMetric());

		return calcMetrics;
	}
}

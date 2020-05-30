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

		Metric loc;
		Metric nom;
		Metric noc;

		if (analyzerType.equals("regex")) {
			if (fileLocation.equals("local")) {
				loc = new LOC(new Regex(), new Local(), filepath);
				nom = new NOM(new Regex(), new Local(), filepath);
				noc = new NOC(new Regex(), new Local(), filepath);
			} else if (fileLocation.equals("web")) {
				loc = new LOC(new Regex(), new Web(), filepath);
				nom = new NOM(new Regex(), new Web(), filepath);
				noc = new NOC(new Regex(), new Web(), filepath);
			} else {
				throw new IllegalArgumentException("Unknown type : " + fileLocation);
			}
		} else if (analyzerType.equals("strcomp")) {
			if (fileLocation.equals("local")) {
				loc = new LOC(new Strcomp(), new Local(), filepath);
				nom = new NOM(new Strcomp(), new Local(), filepath);
				noc = new NOC(new Strcomp(), new Local(), filepath);
			} else if (fileLocation.equals("web")) {
				loc = new LOC(new Strcomp(), new Web(), filepath);
				nom = new NOM(new Strcomp(), new Web(), filepath);
				noc = new NOC(new Strcomp(), new Web(), filepath);
			} else {
				throw new IllegalArgumentException("Unknown type : " + fileLocation);
			}
		} else {
			throw new IllegalArgumentException("Unknown type : " + analyzerType);
		}

		calcMetrics.put("loc", loc.calculateMetric());
		calcMetrics.put("nom", nom.calculateMetric());
		calcMetrics.put("noc", noc.calculateMetric());

		return calcMetrics;
	}
}

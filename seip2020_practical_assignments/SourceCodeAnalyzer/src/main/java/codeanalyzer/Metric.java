package codeanalyzer;

/**
 * This is an abstract class for adding metrics to analyze.
 * 
 * @author pandeliskirpoglou
 *
 */

public abstract class Metric {

	protected AnalyzerType analyzerType;
	protected FileLocation fileLocation;
	protected String filepath;

	public Metric(AnalyzerType analyzerType, FileLocation fileLocation, String filepath) {
		this.analyzerType = analyzerType;
		this.fileLocation = fileLocation;
		this.filepath = filepath;
	}

	/**
	 * Calculates the value of the metric
	 * 
	 * @return calculatedMetric int value of the metric
	 */

	public abstract int calculateMetric();

}

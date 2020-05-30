package codeanalyzer;

/**
 * This is the NOC (number of classes) metric class used to calculate this metric.
 * 
 * @author pandeliskirpoglou
 *
 */

public class NOC extends Metric{

	public NOC(AnalyzerType analyzerType, FileLocation fileLocation, String filepath) {
		super(analyzerType, fileLocation, filepath);
	}
	
	/**
	 * Calculates the value of NOC metric
	 * 
	 * @return noc int value of current metric.
	 */

	@Override
	public int calculateMetric() {
		int noc = this.analyzerType.calculateNOC(this.fileLocation, this.filepath);
		return noc;
	}

	
}

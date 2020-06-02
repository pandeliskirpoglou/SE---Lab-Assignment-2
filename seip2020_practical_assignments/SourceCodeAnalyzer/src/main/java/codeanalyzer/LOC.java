package codeanalyzer;

/**
 * This is the LOC (lines of code) metric class used to calculate this metric.
 * 
 * @author pandeliskirpoglou
 *
 */

public class LOC extends Metric {
	
	public LOC(AnalyzerType analyzerType, FileLocation fileLocation, String filepath) {
		super(analyzerType, fileLocation, filepath);
	}
	
	/**
	 * Calculates the value of LOC metric
	 * 
	 * @return loc int value of current metric.
	 */


	@Override
	public int calculateMetric() {
		int loc = this.analyzerType.calculateLOC(this.fileLocation, this.filepath);
		return loc;
	}

}

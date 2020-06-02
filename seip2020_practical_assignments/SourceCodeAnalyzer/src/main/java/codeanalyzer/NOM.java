package codeanalyzer;

/**
 * This is the NOM (number of methods) metric class used to calculate this
 * metric.
 * 
 * @author pandeliskirpoglou
 *
 */

public class NOM extends Metric {

	public NOM(AnalyzerType analyzerType, FileLocation fileLocation, String filepath) {
		super(analyzerType, fileLocation, filepath);
	}

	/**
	 * Calculates the value of NOM metric
	 * 
	 * @return nom int value of current metric.
	 */

	@Override
	public int calculateMetric() {
		int nom = this.analyzerType.calculateNOM(this.fileLocation, this.filepath);
		return nom;
	}

}

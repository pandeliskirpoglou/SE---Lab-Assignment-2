package codeanalyzer;

/**
 * This class instantiates the appropriate exporter according to what the client
 * asked for.
 * 
 * @author pandeliskirpoglou
 *
 */

public class MetricsExporterFactory {

	/**
	 * Chooses the appropriate instantiation.
	 * 
	 * @param outputType the type of the output file (<b>csv</b> for csv
	 *                   exportables, <b>json</bmet> for json exportables).
	 * @return a MetricsExporter object that is intantiated with the appropriate
	 *         interface's implementation <b>new JSONExporter</b> or
	 *         <b>CSVExporter</b>
	 * @throws IllegalArgumentException
	 */

	public MetricsExporter createMetricsExporter(String outputType) {
		MetricsExporter metricsE;
		if (outputType.equals("csv")) {
			metricsE = new CSVExporter();
		} else if (outputType.equals("json")) {
			metricsE = new JSONExporter();
		} else {
			throw new IllegalArgumentException("Unknown type : " + outputType);
		}

		return metricsE;
	}

}

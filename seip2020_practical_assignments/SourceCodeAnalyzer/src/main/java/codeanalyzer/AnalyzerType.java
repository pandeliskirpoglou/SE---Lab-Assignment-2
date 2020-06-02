package codeanalyzer;

/**
 * This is an interface used to calculate metrics according to analyze type
 * asked.
 * 
 * @author pandeliskirpoglou
 *
 */

public interface AnalyzerType {

	/**
	 * Calculates the value of LOC metric according to analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return loc int value of current metric for certain analyzer type
	 */

	public int calculateLOC(FileLocation fileLocation, String filepath);

	/**
	 * Calculates the value of NOC metric according to analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return noc int value of current metric for certain analyzer type
	 */

	public int calculateNOC(FileLocation fileLocation, String filepath);

	/**
	 * Calculates the value of NOM metric according to analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return nom int value of current metric for certain analyzer type
	 */

	public int calculateNOM(FileLocation fileLocation, String filepath);

}

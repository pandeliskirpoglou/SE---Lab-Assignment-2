package codeanalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This is a class that calculates metrics according to Regex analyzer type
 * 
 * @author agkortzis
 * @author pandeliskirpoglou
 *
 */

public class Regex implements AnalyzerType {

	/**
	 * Calculates the value of LOC metric according to Regex analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return loc int value of current metric for certain analyzer type
	 */

	@Override
	public int calculateLOC(FileLocation fileLocation, String filepath) {
		String sourceCode = fileLocation.readFileIntoString(filepath);
		int nonCodeLinesCounter = 0;
		int loc = 0;
		if (!sourceCode.equals(" ")) {
			Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
			Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);
	
			while (nonCodeLinesMatcher.find()) {
				nonCodeLinesCounter++;
			}
	
			int sourceFileLength = sourceCode.split("\n").length;
			loc = sourceFileLength - nonCodeLinesCounter;
		} else {
			loc = 0;
		}
			return loc;
	}
	
	/**
	 * Calculates the value of NOC metric according to Regex analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return classCounter int value of current metric for certain analyzer type
	 */

	@Override
	public int calculateNOC(FileLocation fileLocation, String filepath) {
		String sourceCode = fileLocation.readFileIntoString(filepath);
		int classCounter = 0;
		if (!sourceCode.equals(" ")) {
			Pattern pattern = Pattern.compile(".*\\s*class\\s+.*");
			Matcher classSignatures = pattern.matcher(sourceCode);
	
			while (classSignatures.find()) {
				classCounter++;
			} 
		} else {
			classCounter = 0;
		}
		return classCounter;
	}
	
	/**
	 * Calculates the value of NOM metric according to Regex analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return methodCounter int value of current metric for certain analyzer type
	 */

	@Override
	public int calculateNOM(FileLocation fileLocation, String filepath) {
		String sourceCode = fileLocation.readFileIntoString(filepath);
		int methodCounter = 0;
		if (!sourceCode.equals(" ")) {
			Pattern pattern = Pattern.compile(
					".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*");
			Matcher methodSignatures = pattern.matcher(sourceCode);
	
			while (methodSignatures.find()) {
				methodCounter++;
			}
		} else {
			methodCounter = 0;
		}
		return methodCounter;
	}

}

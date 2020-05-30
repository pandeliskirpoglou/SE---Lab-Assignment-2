package codeanalyzer;

import java.util.List;

/**
 * This is a class that calculates metrics according to Strcomp analyzer type
 * 
 * @author agkortzis
 * @author pandeliskirpoglou
 *
 */

public class Strcomp implements AnalyzerType {
	
	/**
	 * Calculates the value of LOC metric according to Strcomp analyzer type
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
		List<String> sourceCodeList = fileLocation.readFileIntoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); // clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{")
					|| line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc;
	}
	
	/**
	 * Calculates the value of NOC metric according to Strcomp analyzer type
	 * 
	 * @param fileLocation the object defining the location of a file (<b>new
	 *                     Local</b> for locally stored files, <b>new Web</b> for
	 *                     files stored on the web).
	 * @param filepath     the path of the existing file examined
	 * 
	 * @return classCounter int value of current metric for certain analyzer type
	 */

	@Override
	public int caluclateNOC(FileLocation fileLocation, String filepath) {
		List<String> sourceCodeList = fileLocation.readFileIntoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); // remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter;
	}
	
	/**
	 * Calculates the value of NOM metric according to Strcomp analyzer type
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
		List<String> sourceCodeList = fileLocation.readFileIntoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.trim(); // clear all leading and trailing white spaces
			if (((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String")) && line.contains("(")
					&& line.contains(")") && line.contains("{"))
				methodCounter++;
		}
		return methodCounter;
	}

}

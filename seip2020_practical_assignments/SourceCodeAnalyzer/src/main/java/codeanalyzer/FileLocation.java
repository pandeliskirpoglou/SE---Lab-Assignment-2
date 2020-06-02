package codeanalyzer;

import java.util.List;

/**
 * This is an interface used to read files into List<String> or Strings
 * 
 * @author pandeliskirpoglou
 *
 */

public interface FileLocation {

	/**
	 * Reads a file and converts it into List<String>
	 *
	 * @param filepath the path of the existing file examined
	 * 
	 * @return a List<String> containing the lines of a file
	 * 
	 */

	public List<String> readFileIntoList(String filepath);

	/**
	 * Reads a file and converts it into String
	 *
	 * @param filepath the path of the existing file examined
	 * 
	 * @return a String containing the lines of a file
	 * 
	 */

	public String readFileIntoString(String filepath);
}

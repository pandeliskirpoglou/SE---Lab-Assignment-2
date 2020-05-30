package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class used to read files with local file location
 * 
 * @author agkortzis
 * @author pandeliskirpoglou
 *
 */

public class Local implements FileLocation {

	/**
	 * Reads a file and converts it into List<String>
	 *
	 * @param filepath the path of the existing file examined
	 * 
	 * @return lines a List<String> containing the lines of a file
	 * 
	 */

	@Override
	public List<String> readFileIntoList(String filepath) {
		List<String> lines = new ArrayList<>();
		File file = new File(filepath);
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			// read a file stored in the web
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * Reads a file and converts it into String
	 *
	 * @param filepath the path of the existing file examined
	 * 
	 * @return sb a String containing the lines of a file
	 * 
	 */

	@Override
	public String readFileIntoString(String filepath) {
		StringBuilder sb = new StringBuilder();
		File file = new File(filepath);
		String line = null;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			// read a file stored in the web
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

}

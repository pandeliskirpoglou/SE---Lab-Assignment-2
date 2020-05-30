package codeanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class used to read files with web file location
 * 
 * @author agkortzis
 * @author pandeliskirpoglou
 *
 */

public class Web implements FileLocation {

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
		String line = null;
		try {
			URL url = new URL(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
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
		String line = null;
		try {
			URL url = new URL(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}

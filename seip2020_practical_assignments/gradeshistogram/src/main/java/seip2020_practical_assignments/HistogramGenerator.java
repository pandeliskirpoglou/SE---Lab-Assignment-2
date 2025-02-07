package seip2020_practical_assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author pandeliskirpoglou This class demonstrates how to build a histogram of
 *         grades with JFreeChart
 * @since March 2020
 */

public class HistogramGenerator {

	public static void main(String[] args) {
		String path = args[0];
		System.out.println(path);
		int[] grades = getGrades(path);
		generateChart(grades);
	}

	/***
	 * 
	 * This method receives a path of a file, opens it and stores the frequences of the 
	 * grades given in an array called grades.
	 * 
	 * @param path A string including the path of the file given from the user
	 */

	
	public static int[] getGrades(String path) {
		int[] grades = new int[11];
		int grade = 0;
		try {

			Scanner file = new Scanner(new File(path));

			while (file.hasNextLine()) {
				grade = Integer.parseInt(file.nextLine());
				if (grade >= 0 && grade <= 10) {
					grades[grade]++;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found! \nThe path you gave is not correct.");
		}

		return grades;
	}

	/***
	 * 
	 * This method receives an array of the frequencies of the grades found in the file given. In return
	 * it provides and shows a histogram of those grades with the grades being on the X axis and the
	 * frequencies on the Y axis.
	 * 
	 * @param dataValues A single dimension array including the frequencies of the grades
	 */

	
	public static void generateChart(int[] dataValues) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that can be
		 * visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many series in
		 * one dataset.
		 */
		XYSeries data = new XYSeries("random values");

		/*
		 * Populating the XYSeries data object from the input Integer array values.
		 */
		for (int i = 0; i < dataValues.length; i++) {
			data.add(i, dataValues[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Histogram of Grades", "Grades", "Frequency", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the previously
		 * created chart.
		 */
		ChartFrame frame = new ChartFrame("Histogram", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}

}

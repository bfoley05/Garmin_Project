package Garmin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The purpose of this class is to calculate and run through code
 * to get the intensity determined by multiple factors of the data set
 * @author Brandon Foley
 * @version 1.0
 */

public class Intensity {
    public static double benchmarkIntesity;
    List< List<String> > data = new ArrayList<>();

	/**
	 * Overloaded constructor that takes in the data in 2D array
	 * Is used to print the data options and then the user selects
	 * whcih activity they want to analyze
	 * @param data 2D array taken from csv file
	 */
    public Intensity(List<List<String>> data){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
		analyzeIntensity(data);
		System.out.println("You have " + (data.size()-1) + " lines of data\n");
        for(int i = 1; i<data.size(); i++){
            System.out.println(i + ": " + data.get(i).get(3));
            if(i%5 == 0){
                System.out.println("");
            }
        }
		System.out.print("Please enter a number of data you would like to analzye in your data set: ");
		int intInput = sc.nextInt();

		double oneIntensity = getOneIntensity(data, intInput);
        System.out.println("---------------------------------------------------------------------------");
		if(oneIntensity >= benchmarkIntesity){
			System.out.println("This exercise is an intense workout at " + Math.round(((oneIntensity/benchmarkIntesity)*100)) + "% of your average intensity" );
		}else{
			System.out.println("This is not a high intensity exercise at " + Math.round(((oneIntensity/benchmarkIntesity)*100)) + "% of your average intensity");
		}
        System.out.println("---------------------------------------------------------------------------");
    }


	/**
	 * Method used to convert time to one double in mins
	 * instead of in hours and mins
	 * @param data 2D array taken from csv file
	 * @return the time as a double
	 */
    public static double convertTime(List<List<String>> data){
		double time = 0.0;
		for(int i = 1; i <data.size(); i++){
			String tempData = data.get(i).get(6);
			System.out.println(tempData);
			String temp = tempData.substring(0, tempData.indexOf("."));
			tempData = tempData.substring(tempData.indexOf(".") + 1);
			time += Double.parseDouble(tempData);
			time += Integer.parseInt(temp)*60;
		}
		return time;
	}
	
	/**
	 * Finds the intensity of one exercise at the specified index
	 * @param data 2D array taken from csv file
	 * @param x the index of what activity is going to be analyzed
	 * @return a double of the intensity of that exercise
	 */
	public static double getOneIntensity(List<List<String>> data,int x){
		double intensityBenchmark = 0.0;
		intensityBenchmark += Double.parseDouble(data.get(x).get(4));
		intensityBenchmark = intensityBenchmark * Integer.parseInt(data.get(x).get(7));
		intensityBenchmark /= convertTime(data);
		intensityBenchmark *= 100;
		return intensityBenchmark;
	}
	/**
	 * Creates the benchmark intensity for the class
	 * @param data 2D array taken from csv file
	 */
	public static void analyzeIntensity(List<List<String>> data){
		double intensityBenchmark = 0.0;
		for(int i = 1; i <data.size(); i++){
			intensityBenchmark += Double.parseDouble(data.get(i).get(4));
			intensityBenchmark = intensityBenchmark * Integer.parseInt(data.get(i).get(7));
			intensityBenchmark /= convertTime(data);
		}
		intensityBenchmark *= 100;
		benchmarkIntesity = intensityBenchmark;
	}
}

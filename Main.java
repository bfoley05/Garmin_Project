package Garmin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * The purpose of this program is to parse through and allow the user to view
 * certian aspects of their garmin data from a garmin watch
 * @author Brandon Foley
 * @version 1.0
 */

public class Main {

	public static double benchmarkIntesity;
    public static void main(String[] args){
		System.out.println("\n\n\n\n");
		Intensity i;
		Request r;
		RunningPower rp;
		Scanner sc = new Scanner(System.in);
        List< List<String> > data = new ArrayList<>();
        data = readFile();
		String input = "t";

		while(!input.equals("q")){
			System.out.println("What would you like to do:\n1. Analyze intensity\n2. Request all from one exercise\n3. Calculate running power\ntype 'q' to quit");
			input = sc.nextLine();
			if(input.equals("1")){
				System.out.println("\n");
				i = new Intensity(data);
			}else if(input.equals("2")){
				System.out.println("\n");
				r = new Request(data);
			}else if(input.equals("3")){
				System.out.println("\n");
				rp = new RunningPower(data);
			}
		}

		

    }
	/**
	 * Method used to read the CSV file into a 2D array
	 * @return 2D array is returned with the values from CSV file taken from garmin
	 */
    public static List< List<String> > readFile(){
        List< List<String> > thing = new ArrayList<>();
        try
		{
			List< List<String> > data = new ArrayList<>();//list of lists to store data
			String file = "/Users/brandonfoley/Documents/Activities.csv";//file path
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Reading until we run out of lines
			String line = br.readLine();
			while(line != null)
			{
				List<String> lineData = Arrays.asList(line.split(","));//splitting lines
				data.add(lineData);
				line = br.readLine();
			}
			
			//printing the fetched data
			br.close();
            return data;
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
        return thing;
    }
}

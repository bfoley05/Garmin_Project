package Garmin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		ChangeData changer = new ChangeData(data);
		data = changer.getList();
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

	public static List<List<String>> readFile() {
        List<List<String>> data = new ArrayList<>();

        try {
            String file = "/Users/brandonfoley/Documents/CPSC_Courses/Garmin/Activities.csv";
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                List<String> lineData = parseCSVLine(line);
                data.add(lineData);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static List<String> parseCSVLine(String line) {
        List<String> values = new ArrayList<>();
        String[] tokens = line.split(",", 4);  // Split the line into first 3 values and the rest
        for (int i = 0; i < 3; i++) {
            values.add(tokens[i].trim());
        }
        if (tokens.length == 4) {
            String[] quotedValues = tokens[3].split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            for (String quotedValue : quotedValues) {
                values.add(quotedValue.trim().replaceAll("\"", ""));
            }
        }
        return values;
    }
}

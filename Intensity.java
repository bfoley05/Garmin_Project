package Garmin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Intensity {
    public static double benchmarkIntesity;
    List< List<String> > data = new ArrayList<>();

    public Intensity(){
        System.out.println("Test failed");
    }

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

    public static double convertTime(List<List<String>> data){
		double time = 0.0;
		for(int i = 1; i <data.size(); i++){
			String tempData = data.get(i).get(6);
			String temp = tempData.substring(0, tempData.indexOf("."));
			tempData = tempData.substring(tempData.indexOf(".") + 1);
			time += Double.parseDouble(tempData);
			time += Integer.parseInt(temp);
		}
		return time;
	}

	public static double getOneIntensity(List<List<String>> data,int x){
		double intensityBenchmark = 0.0;
		intensityBenchmark += Double.parseDouble(data.get(x).get(4));
		intensityBenchmark = intensityBenchmark * Integer.parseInt(data.get(x).get(7));
		intensityBenchmark /= convertTime(data);
		intensityBenchmark *= 1000;
		return intensityBenchmark;
	}

	public static void analyzeIntensity(List<List<String>> data){
		double intensityBenchmark = 0.0;
		for(int i = 1; i <data.size(); i++){
			intensityBenchmark += Double.parseDouble(data.get(i).get(4));
			intensityBenchmark = intensityBenchmark * Integer.parseInt(data.get(i).get(7));
			intensityBenchmark /= convertTime(data);
		}
		intensityBenchmark *= 1000;
		benchmarkIntesity = intensityBenchmark;
	}
}

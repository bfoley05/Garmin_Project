package Garmin;
import java.util.List;
import java.util.Scanner;

/**
 * The prupose of this class is to get all the data from one specific exercise
 * @author Brandon Foley
 * @version 1.0
 */

public class RequestAll {

    /**
     * Overloaded constructor to see if the user wants to see all data for
     * one specific activity and asks for position of that activity
     * @param data 2D array taken from csv file
     */
    public RequestAll(List<List<String>> data){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to see all the data for one of these activites(y/n)");
        String input = sc.nextLine();
        if(input.equals("y")){
            System.out.print("What is the position of the activity you want to see: ");
            int index = sc.nextInt();
            printAll(data.get(index));
        }
    }

    /**
     * Method used to print all the data of one specific activity
     * @param dataLine The one activity taken from 2D array
     */
    public static void printAll(List<String> dataLine){
        System.out.println("---------------------------------------------------------------------");
        System.out.println(dataLine.get(0) + ", " + dataLine.get(3) + ": ");
        System.out.println("Favorite: " + dataLine.get(2));
        System.out.println("Distance: " + dataLine.get(4));
        System.out.println("Calories: " + dataLine.get(5));
        System.out.println("Time: " + dataLine.get(6));
        System.out.println("Date: " + dataLine.get(1));
        System.out.println("Avg HR: " + dataLine.get(7));
        System.out.println("Max HR: " + dataLine.get(8));
        System.out.println("Avg pace: " + dataLine.get(11));
        System.out.println("Best pace: " + dataLine.get(12));
        System.out.println("Ascent: " + dataLine.get(13));
        System.out.println("Descent: " + dataLine.get(14));
        System.out.println("---------------------------------------------------------------------");
    }
}

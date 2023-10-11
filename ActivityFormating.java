package Garmin;
import java.util.List;
/**
 * The purpose of this class is to format one line of data into
 * a better format that is more readable.
 * @author Brandon Foley
 * @version 1.0
 */


public class ActivityFormating {
    List<String> dataLine;

    /**
     * Overloaded constructor that takes in the single line
     * of data in a List and instantiates the list for the class
     * @param dataLine type List<String>
     */
    public ActivityFormating(List<String> dataLine){
        this.dataLine = dataLine;
    }
    /**
     * Method used to print out all the data in a clean
     * and organized manner
     */
    public void printFormating(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println(dataLine.get(0) + " " + dataLine.get(3) + ": ");
        System.out.println("Distance: " + dataLine.get(4));
        System.out.println("Calories: " + dataLine.get(5));
        System.out.println("Time: " + dataLine.get(6));
        System.out.println("---------------------------------------------------------------------");
    }
}

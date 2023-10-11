package Garmin;
import java.util.List;


public class ActivityFormating {
    List<String> dataLine;
    public ActivityFormating(){
        System.out.println("test failed");
    }
    public ActivityFormating(List<String> dataLine){
        this.dataLine = dataLine;
    }

    public void printFormating(){
        System.out.println("---------------------------------------------------------------------");
        System.out.println(dataLine.get(0) + " " + dataLine.get(3) + ": ");
        System.out.println("Distance: " + dataLine.get(4));
        System.out.println("Calories: " + dataLine.get(5));
        System.out.println("Time: " + dataLine.get(6));
        System.out.println("---------------------------------------------------------------------");
    }
}

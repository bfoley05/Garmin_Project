package Garmin;
import java.util.List;
import java.util.Scanner;


public class RequestAll {
    public RequestAll(){
        System.out.println("Test failed");
    }
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

package Garmin;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Request {
    static LinkedList<String> activities = new LinkedList<>();
    Scanner sc = new Scanner(System.in);
    public Request(){
        System.out.println("test failed");
    }
    public Request(List<List<String>> data){
        for(int i = 1; i < data.size(); i++){
            if(!activities.contains(data.get(i).get(0))){
                activities.add(data.get(i).get(0));
            }
        }
        printOptions();
        System.out.println("What activity would you like to look at: ");
        int index = sc.nextInt();
        getOptions(index,data);
        RequestAll printAll = new RequestAll(data);
        
    }

    public static void printOptions(){
        for (int i = 0; i < activities.size(); i++){
            System.out.println(i+1 + ". " + activities.get(i));
        }
        System.out.println("\n");
    }

    public static void getOptions(int index,List<List<String>> data){
        ActivityFormating printActivityFormating;
        String key = activities.get(index-1);
        for(int i = 1; i < data.size(); i++){
            if(data.get(i).get(0).equals(key)){
                printActivityFormating = new ActivityFormating(data.get(i));
                System.out.println("The position of this activity is: " + i);
                printActivityFormating.printFormating();
            }
        }
    }


}

package Garmin;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * The purpose of this class is to allow the user to look at one activity
 * in particular if they want to look at it more in depth, connects to
 * ReqesutAll class if the user would like to go even more in depth for
 * a specific workout in the catagory
 * @author Brandon Foley
 * @version 1.0
 */

public class Request {
    static LinkedList<String> activities = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    /**
     * Overloaded constructor that is used to print out all the types of
     * workouts they have and ask which they would like to look at
     * @param data 2D array taken from csv file
     */
    public Request(List<List<String>> data){
        for(int i = 1; i < data.size(); i++){
            if(!activities.contains(data.get(i).get(0))){
                activities.add(data.get(i).get(0));
            }
        }
        printOptions();
        System.out.println("What activity would you like to look at: ");
        int index = sc.nextInt();
        printOptions(index,data);
        RequestAll printAll = new RequestAll(data);
        
    }

    /**
     * Method used to print all the options of activities they have
     */
    public static void printOptions(){
        for (int i = 0; i < activities.size(); i++){
            System.out.println(i+1 + ". " + activities.get(i));
        }
        System.out.println("\n");
    }

    /**
     * Method used to print all of the options from the chosen activity
     * @param index is index for linked list to see what activity the user wants to see
     * @param data 2D array taken from csv file
     */
    public static void printOptions(int index,List<List<String>> data){
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

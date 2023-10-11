package Garmin;
import java.util.List;
import java.util.Scanner;

public class RunningPower {

    /**
     * Overloaded constructor used to print out the options for the average power calculations
     * and then asks the user whcih one they would like to calculate or for all
     * @param data 2D array taken from csv file
     */
    public RunningPower(List<List<String>> data){
        Scanner sc = new Scanner(System.in);
        ActivityFormating printActivityFormating;
        for(int i = 1; i < data.size(); i++){
            if(data.get(i).get(0).equals("Running") || data.get(i).get(0).equals("Cycling")){
                printActivityFormating = new ActivityFormating(data.get(i));
                System.out.println("The position of this running activity is: " + i);
                printActivityFormating.printFormating();
            }
        }
        System.out.println("Please enter the position of the running activity you would like to caculate running power for: ");
        System.out.println("For all please type 0");
        int index = sc.nextInt();

        if(index == 0){
            printAllRunningPower(data);
        }else{
            double runningPower = calcRunningPower(index, data);
            ActivityFormating af = new ActivityFormating(data.get(index));
            System.out.println("\n\nThe average power is: " + runningPower + " for: ");
            af.printFormating();
        }
    }

    /**
     * Method used to print out the average power of all running and cycling activites
     * @param data 2D array taken from csv file
     */
    public static void printAllRunningPower(List<List<String>> data){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your weight in lbs to the nearest pound: ");
        int weight = sc.nextInt();
        ActivityFormating active;
        for(int i = 1; i < data.size(); i++){
            if(data.get(i).get(0).equals("Running") || data.get(i).get(0).equals("Cycling")){
                active = new ActivityFormating(data.get(i));
                double averagePower = calcRunningPowerAll(i, data,weight);
                System.out.println("The position of this running activity is: " + i + ". The average power is: " + averagePower);
                active.printFormating();
            }
        }
    }

    /**
     * Method used to calculate the averagePower of all data sets.
     * same as calcRunningPower however takes in weight so weight
     * is not asked for multiple times
     * @param index spcific index of the activites wanted to be printed
     * @param data 2D array taken from csv file
     * @param w weight of the user
     * @return double that is the average power
     */
    public static double calcRunningPowerAll(int index, List<List<String>> data, int w){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your weight in lbs to the nearest pound: ");
        double weight = w/2.205;
        double force = weight*9.81;
        double work = force*Double.parseDouble(data.get(index).get(4));
        double power = work/parseTime(data.get(index));
        return power;
    }

    /**
     * Method used to caculate the running power of one specific activity
     * @param index specific index of the activity wanted to be printed
     * @param data 2D array taken from csv file
     * @return double that is the average power
     */
    public static double calcRunningPower(int index, List<List<String>> data){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your weight in lbs to the nearest pound: ");
        double weight = sc.nextInt()/2.205;
        double force = weight*9.81;
        double work = force*Double.parseDouble(data.get(index).get(4));
        double power = work/parseTime(data.get(index));
        return power;
    }
    /**
     * Method used to parse the time and change it into seconds
     * @param dataLine one acvitivty from the 2D array of activities 
     * @return int which is seconds
     */
    public static int parseTime(List<String> dataLine){
        String temp = dataLine.get(6);
        String firstPart = temp.substring(0, 2);
        String secondPart = temp.substring(3, 5);
        String thirdPart = temp.substring(6, 8);
        int time = Integer.parseInt(firstPart)*60*60;
        time+= Integer.parseInt(secondPart)*60;
        time+= Integer.parseInt(thirdPart);
        return time;
    }
}

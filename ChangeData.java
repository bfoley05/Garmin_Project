package Garmin;
import java.util.List;

public class ChangeData {
    static List<List<String>> data;
    public ChangeData(List<List<String>> d){
        data = d;
        editTimes();
        editVariables();
    }

    public static void editTimes(){
        for(int i = 1; i < data.size(); i++){
            if(data.get(i).get(6).indexOf(".") != -1){
                String time = data.get(i).get(6).substring(0,data.get(i).get(6).indexOf("."));
                data.get(i).set(6,time);
            }
        }
    }

    public static void editVariables(){
        String temp;
        for(int i = 1; i<data.size(); i++){
            for(int j = 0; j < data.get(0).size(); j++){
                temp = data.get(i).get(j).replace("\"","");
                data.get(i).set(j, temp);
                temp = data.get(i).get(j).replace(":",".");
                data.get(i).set(j, temp);
            }
        }
    }

    public List<List<String>> getList(){
        return data;
    }
}

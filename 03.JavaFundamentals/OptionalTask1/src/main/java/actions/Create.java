package actions;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Create {

    public static int[] randomArray(int count, int randomSize){
        int[] randomArray = new int[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            randomArray[i] = random.nextInt(randomSize);
        }
        return randomArray;
    }

    public static Map monthOfYear(){
        Map<Integer, String> monthOfYear = new HashMap<Integer, String>();
        monthOfYear.put(1, "January");
        monthOfYear.put(2, "February");
        monthOfYear.put(3, "March");
        monthOfYear.put(4, "April");
        monthOfYear.put(5, "May");
        monthOfYear.put(6, "June");
        monthOfYear.put(7, "Jule");
        monthOfYear.put(8, "August");
        monthOfYear.put(9, "September");
        monthOfYear.put(10, "October");
        monthOfYear.put(11, "November");
        monthOfYear.put(12, "December");
        return monthOfYear;
    }
}

package actions;

import java.util.Scanner;

public class GetInfo {

    public static String getString(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String valueFromUser = scanner.nextLine();
        return valueFromUser;
    }

    public static int getInt(String message){
            System.out.println(message);
            Scanner scanner = new Scanner(System.in);
            int valueFromUser = scanner.nextInt();
            return valueFromUser;
    }

    public static boolean getBoolean(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean valueFromUser = scanner.nextBoolean();
        return valueFromUser;
    }
}

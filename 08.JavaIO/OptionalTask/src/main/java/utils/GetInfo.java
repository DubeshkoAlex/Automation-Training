package utils;

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

    public static int[] getIntArray(String message1, String message2){
        int count = getInt(message1);
        System.out.println(message2);
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[count];
        for(int i = 0; i < count; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }
}

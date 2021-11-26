import actions.Create;
import actions.GetInfo;
import actions.Output;

public class Tasks {

    public static void task1(){
        System.out.println("Hello " + GetInfo.getString("Please enter your name: "));
    }

    public static void task2() {
        System.out.println("Check this task with help of cmd and commands \n" +
                            " \"javac Main.java\" and \"java Main some_arguments\"");
    }

    public static void task3(){
        int count = GetInfo.getInt("Please input a count of numbers: ");
        boolean newLine = GetInfo.getBoolean("Choose the option: switch to a new line - true; without switching - false");
        int[] arrayOfNumbers = Create.randomArray(count,100);
        Output.arrayOfNumbers(arrayOfNumbers,newLine);
    }

    public static void task4(){
        System.out.println("Check this task with help of cmd and commands \n" +
                " \"javac Main.java\" and \"java Main some_arguments\"");
    }

    public static void task5(){
        int numberOfMonth = GetInfo.getInt("Please input a month number: ");
        if(numberOfMonth > 0 && numberOfMonth <= 12){
            System.out.println(Create.monthOfYear().get(numberOfMonth));
        }
        else{
            System.out.println("Incorrect month number! ");
        }
    }

}

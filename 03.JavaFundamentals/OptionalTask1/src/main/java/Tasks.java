import actions.GetInfo;
import actions.OperationWithNumbers;
import actions.Output;

public class Tasks {

    public static void task1(){
        int[] arrayOfNumbers = GetInfo.getIntArray("Enter count of numbers: ", "Enter the numbers");
        System.out.println("The shortest number(s): ");
        int[] minNumbers = OperationWithNumbers.minLengthNumber(arrayOfNumbers);
        Output.arrayOfNumbers(minNumbers,false,false);
        System.out.println("The length of shortest numbers: \n" + String.valueOf(minNumbers[0]).length() + "\n");
        System.out.println("The longest number(s): ");
        int[] maxNumbers = OperationWithNumbers.maxLengthNumber(arrayOfNumbers);
        Output.arrayOfNumbers(maxNumbers,false,false);
        System.out.println("The length of longest numbers: \n" + String.valueOf(maxNumbers[0]).length() + "\n");
    }

    public static void task2(){
        int[] arrayOfNumbers = GetInfo.getIntArray("Enter count of numbers: ", "Enter the numbers");
        boolean reverse = GetInfo.getBoolean("Choose the options: asc - true, desc - false");
        System.out.println("The sorted array of numbers by length: ");
        Output.arrayOfNumbers(OperationWithNumbers.sortByLength(arrayOfNumbers),false,reverse);
    }

    public static void task3(){
        int[] arrayOfNumbers = GetInfo.getIntArray("Enter count of numbers: ", "Enter the numbers");
        double averageValue = OperationWithNumbers.averageValue(OperationWithNumbers.numbersLength(arrayOfNumbers));
        boolean moreThenAverage = GetInfo.getBoolean("Enter the option: more then average - true, less then average - false");
        Output.arrayOfNumbers(OperationWithNumbers.compareArrayWithAverage(arrayOfNumbers,averageValue,moreThenAverage),false,true);
    }

    public static void task4(){
        int[] arrayOfNumbers = GetInfo.getIntArray("Please enter the count of numbers: ","Enter the numbers: ");
        System.out.println("The number you are looking for: ");
        System.out.println(OperationWithNumbers.firstUniqueNumbersValue(arrayOfNumbers));
    }
}

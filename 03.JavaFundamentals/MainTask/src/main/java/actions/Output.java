package actions;

public class Output {

    public static void arrayOfNumbers(int[] arrayOfNumbers, boolean newLine){
        for(int i = 0; i < arrayOfNumbers.length; i++){
            if(newLine){
                System.out.println(arrayOfNumbers[i]);
            }
            else {
                System.out.print(arrayOfNumbers[i] + " ");
            }
        }
    }
}

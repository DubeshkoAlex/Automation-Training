package actions;

public class Output {

    public static void arrayOfNumbers(int[] arrayOfNumbers, boolean newLine, boolean asc){

        if(!asc){
            for (int i = arrayOfNumbers.length-1; i >= 0; i--){
                if(newLine){
                    System.out.println(arrayOfNumbers[i]);
                }
                else {
                    System.out.print(arrayOfNumbers[i] + " ");
                }
            }
        }
        else{
            for(int i = 0; i < arrayOfNumbers.length; i++){
                if(newLine){
                    System.out.println(arrayOfNumbers[i]);
                }
                else {
                    System.out.print(arrayOfNumbers[i] + " ");
                }
            }
        }
        System.out.println("\n");
    }
}

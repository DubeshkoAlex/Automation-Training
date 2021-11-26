package actions;

public class Output {
    public static void arrayOfNumbers(int[] arrayOfNumbers, boolean newLine, boolean reverse){
        if(reverse){
            for (int i = arrayOfNumbers.length-1; i >= 0; i--){
                if(newLine){
                    System.out.format("%6s",arrayOfNumbers[i] + "\n");
                }
                else {
                    System.out.format("%6s",arrayOfNumbers[i] + " ");
                }
            }
        }
        else{
            for(int i = 0; i < arrayOfNumbers.length; i++){

                if(newLine){
                    System.out.format("%6s",arrayOfNumbers[i] + "\n");
                }
                else {
                    System.out.format("%6s",arrayOfNumbers[i] + " ");
                }
            }
        }
        System.out.println("\n");
    }

    public static void matrix(int[][]matrix){
        for(int i = 0; i < matrix.length; i++){
            arrayOfNumbers(matrix[i],false,false);
        }
    }
}

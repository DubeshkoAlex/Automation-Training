package actions;

public class OperationWithMatrix {
    public static void sortMatrix(int[][] arr, int k, boolean columnSort) {
        // if true sort by column else sort my row
        int from = 0;
        int to = arr.length - 1;
        if(columnSort){
            quickSort(arr,from,to,k);
        }
        else{
            reverseMatrix(arr);
            quickSort(arr,from,to,k);
            reverseMatrix(arr);
        }
    }

    public static void quickSort(int[][] arr, int from, int to, int k){
        if(from < to){
            int divideIndex = partition(arr, from, to,k);
            quickSort(arr,from,divideIndex - 1,k);
            quickSort(arr, divideIndex, to,k);
        }
    }

    private static int partition(int[][] arr, int from, int to, int k){
        int rightIndex = to;
        int leftIndex = from;
        int pivot = arr[(from+to)/2][k];
        while(leftIndex <= rightIndex){
            while (arr[leftIndex][k] < pivot){
                leftIndex++;
            }
            while (arr[rightIndex][k] > pivot){
                rightIndex--;
            }
            if(leftIndex <= rightIndex){
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swap(int[][] array, int index1, int index2){
       arraySwap(array[index1],array[index2]);
    }

    public static void arraySwap(int[] array1, int[] array2){
        int[] tmp = new int[array1.length];
        for (int i = 0; i < array1.length; i++){
            tmp[i] = array1[i];
            array1[i] = array2[i];
            array2[i] = tmp[i];
        }
    }

    public static void reverseMatrix(int[][] array){
        int[][] matrix = new int[array.length][array.length];
        int k = 0;
        for (int i = 0; i < array.length; i++,k++){
            for (int j = 0; j < array.length; j++){
                matrix[j][k] = array[i][j];
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                array[i][j] = matrix[i][j];
            }
        }
    }

    public static void countRaise(int[][] array, boolean raise){
        int[] lineArray = new int[array.length*array.length];
        int k = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length; j++){
                lineArray[k] = array[i][j];
                k++;
            }
        }
        int counter=1;
        int countOfElements = 1;
        int element = lineArray[0];
            for (int i = 0; i < lineArray.length-1; i++){
                if(raise){
                    if(lineArray[i+1]>element){
                        counter++;
                    }
                    else{
                        if(counter>countOfElements){
                            countOfElements = counter;
                        }
                        counter = 1;
                    }
                }
                else {
                    if(lineArray[i+1]<element){
                        counter++;
                    }
                    else{
                        if(counter>countOfElements){
                            countOfElements = counter;
                        }
                        counter = 1;
                    }
                }
                element = lineArray[i+1];
            }
        System.out.println(countOfElements);
    }
}

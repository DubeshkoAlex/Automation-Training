package actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OperationWithNumbers {

    // convert ArrayList<Integer> to simple integer array
    private static int[] convertArrListToArray(ArrayList<Integer> arrayList){
        int [] array = new int[arrayList.toArray().length];
        for(int i = 0; i < arrayList.toArray().length; i++){
            array[i] = arrayList.get(i);
        }
        return array;
    }

    // give the sorted array of unique lengths numbers
    public static int[] numbersLength(int[] arrayOfNumbers){
        ArrayList<Integer> numbersLength = new ArrayList<>();
        for (int i = 0; i < arrayOfNumbers.length; i++){
            if(!numbersLength.contains(String.valueOf(arrayOfNumbers[i]).length())){
                numbersLength.add(String.valueOf(arrayOfNumbers[i]).length());
            }
        }
        Collections.sort(numbersLength);
        int[] numbersLengthArray = convertArrListToArray(numbersLength);
        return numbersLengthArray;
    }

    // give the array of numbers sorted by length
    public static int[] sortByLength(int[] arrayOfNumbers){
        int[] numbersLengthArray = numbersLength(arrayOfNumbers);
        ArrayList<Integer> lengthSortedNumbers = new ArrayList<>();
        for(int i = 0; i < numbersLengthArray.length; i++){
            for(int j = 0; j < arrayOfNumbers.length; j++){
                if(String.valueOf(arrayOfNumbers[j]).length() == numbersLengthArray[i]){
                    lengthSortedNumbers.add(arrayOfNumbers[j]);
                }
            }
        }
        int[] lengthSortedNumbersArray = convertArrListToArray(lengthSortedNumbers);
        return lengthSortedNumbersArray;
    }

    public static int[] maxLengthNumber(int[] arrayOfNumbers){
        int[] lengthNumbers = numbersLength(arrayOfNumbers);
        int maxLength = lengthNumbers[lengthNumbers.length-1];
        ArrayList<Integer> maxLengthNumbers = new ArrayList<>();
        for(int i = 0; i < arrayOfNumbers.length; i++){
            if(String.valueOf(arrayOfNumbers[i]).length()==maxLength){
                maxLengthNumbers.add(arrayOfNumbers[i]);
            }
        }
        int[] maxLengthNumbersArray = convertArrListToArray(maxLengthNumbers);
        return maxLengthNumbersArray;
    }

    public static int[] minLengthNumber(int[] arrayOfNumbers){
        int[] lengthNumbers = numbersLength(arrayOfNumbers);
        int minLength = lengthNumbers[0];
        ArrayList<Integer> minLengthNumbers = new ArrayList<>();
        for(int i = 0; i < arrayOfNumbers.length; i++){
            if(String.valueOf(arrayOfNumbers[i]).length()==minLength){
                minLengthNumbers.add(arrayOfNumbers[i]);
            }
        }
        int[] minLengthNumbersArray = convertArrListToArray(minLengthNumbers);
        return minLengthNumbersArray;
    }

    public static double averageValue(int[] arrayOfNumbers){
        double averageValue;
        double sumOfValues = 0;
        for(int i = 0; i < arrayOfNumbers.length; i++){
            sumOfValues+=arrayOfNumbers[i];
        }
        averageValue = sumOfValues/ arrayOfNumbers.length;
        return averageValue;
    }

    public static int[] compareArrayWithAverage(int[] arrayOfNumbers, double averageValue, boolean moreThenAverage){
        ArrayList<Integer> filteredValues = new ArrayList<>();
        if(moreThenAverage){
            for(int i = 0; i < arrayOfNumbers.length; i++){
                if(String.valueOf(arrayOfNumbers[i]).length()>averageValue){
                    filteredValues.add(arrayOfNumbers[i]);
                }
            }
        }
        else {
            for(int i = 0; i < arrayOfNumbers.length; i++){
                if(String.valueOf(arrayOfNumbers[i]).length()<averageValue){
                    filteredValues.add(arrayOfNumbers[i]);
                }
            }
        }
        int[] filteredValuesArray = convertArrListToArray(filteredValues);
        return filteredValuesArray;
    }

    public static int countUniqueNumbersInValue(int value){
        Map<Integer, String> uniqueValues = new HashMap<Integer, String>();
        char[] arrayOfNumber = String.valueOf(value).toCharArray();
        for(int i = 0; i < arrayOfNumber.length; i++){
            uniqueValues.put(Character.getNumericValue(arrayOfNumber[i]),String.valueOf(arrayOfNumber[i]));
        }
        return uniqueValues.size();
    }

    public static int minArrayValue(int[] arrayOfNumbers){
        int min = arrayOfNumbers[0];
        for (int i = 0; i < arrayOfNumbers.length; i++){
            if(arrayOfNumbers[i]<min){
                min = arrayOfNumbers[i];
            }
        }
        return min;
    }

    public static int maxArrayValue(int[] arrayOfNumbers){
        int max = arrayOfNumbers[0];
        for (int i = 0; i < arrayOfNumbers.length; i++){
            if(arrayOfNumbers[i]>max){
                max = arrayOfNumbers[i];
            }
        }
        return max;
    }

    public static int firstUniqueNumbersValue(int[] arrayOfNumbers){
        int[] uniqueNumbersValue = new int[arrayOfNumbers.length];
        for(int i = 0; i < arrayOfNumbers.length; i++){
            uniqueNumbersValue[i] = countUniqueNumbersInValue(arrayOfNumbers[i]);
        }
        int minUniqueValue = minArrayValue(uniqueNumbersValue);
        int minUniqueNumberValues = 0;
        for(int i = 0; i < arrayOfNumbers.length; i++){
            if(countUniqueNumbersInValue(arrayOfNumbers[i])==minUniqueValue){
                minUniqueNumberValues = arrayOfNumbers[i];
                break;
            }
        }
        return minUniqueNumberValues;
    }
}
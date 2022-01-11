import dataTypeEnum.DataType;
import exceptions.IncorrectDataTypeException;
import exceptions.IncorrectMarkException;
import utils.GetInfo;
import utils.Reader;
import utils.Writer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {

    public static void task1(String sourceFilePath, String outputFilePath, int comparableMark){
        Reader.readFromFile(sourceFilePath).stream().map(s->{
            StringBuilder stringMarks = new StringBuilder();
            StringBuilder stringName = new StringBuilder();
            for (Character ch:s.toCharArray()){
                if(ch.toString().matches("(?ui:[а-яА-Я])")){
                    stringName.append(ch);
                }
                else if(!ch.toString().matches("(?ui:[а-яА-Я])")) {
                    stringMarks.append(ch);
                }
            }
            int marksSum = 0;
            int markCounter = 0;
            String[] stringMarksArray = stringMarks.toString().split(" ");
            for (String mark:stringMarksArray){
                if(!Objects.equals(mark, "")){
                    try {
                        int currentMark = Integer.parseInt(mark);
                        if(currentMark<0 || currentMark>10){
                            throw new IncorrectMarkException("Marks should be in range from 0 to 10");
                        }
                        marksSum+=currentMark;
                        markCounter++;
                    }catch (NumberFormatException e){
                        throw new IncorrectMarkException("Marks include incorrect values!");
                    }
                }
            }
            BigDecimal averageMark = (BigDecimal.valueOf((double) marksSum / (double) markCounter))
                    .setScale(2, RoundingMode.HALF_UP);
            if(averageMark.doubleValue()>comparableMark){
                stringName = new StringBuilder(stringName.toString().toUpperCase(Locale.ROOT));
            }
            return stringName.append(stringMarks);
        }).forEach(s->Writer.writeToFile(outputFilePath,true,s.toString()));
    }

    public static void task2(String sourceFilePath, String outputFilePath){
        String dataType = GetInfo.getString("Input the data type(Integer,double,char,word): ").toLowerCase(Locale.ROOT);
        Map<String, DataType> dataTypes = new HashMap<>();
        dataTypes.put(DataType.INTEGER.getName(),DataType.INTEGER);
        dataTypes.put(DataType.DOUBLE.getName(),DataType.DOUBLE);
        dataTypes.put(DataType.CHAR.getName(),DataType.CHAR);
        dataTypes.put(DataType.WORD.getName(),DataType.WORD);
        Reader.readFromFile(sourceFilePath).stream().map(s->{
            StringBuilder newString = new StringBuilder();
            Pattern pattern = null;
            if(dataTypes.get(dataType)==null){
                throw new IncorrectDataTypeException("Wrong data type!");
            }
            switch (dataTypes.get(dataType)){
                case INTEGER:
                    pattern = Pattern.compile("\\-?(?<![.,])\\b[0-9]+\\b(?![\\.\\,][0-9])");
                    break;
                case DOUBLE:
                    pattern = Pattern.compile("\\-?\\d+[\\.\\,]\\d+");
                    break;
                case CHAR:
                    pattern = Pattern.compile("(?<!\\S)[\\[\\]\\\\\\^\\$\\|\\?\\*\\+\\(\\)#~`<>{}!@№;:\\/\\&+A-zА-я]?[^А-яA-z\\d]");
                    break;
                case WORD:
                    pattern = Pattern.compile("\\b[A-zА-я]{2,}\\b");
                    break;
                default:
                    throw new IncorrectDataTypeException("Wrong data type exception!");
            }
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                newString.append(s.substring(matcher.start(), matcher.end()).replace(" ",""));
                newString.append(" ");
            }
            return newString;
        }).forEach(s->Writer.writeToFile(outputFilePath,true,s.toString()));
    }

    public static void task3(String sourceFilePath, String outputFilePath){

        Reader.readFromFile(sourceFilePath).stream().map(s->{
            Pattern pattern = Pattern.compile("\\b[A-zА-я]{3,5}\\b");
            Matcher matcher = pattern.matcher(s);
            StringBuilder newString = new StringBuilder(s);
            int words = 0;
            while (matcher.find()) {
                words++;
            }
            int wordCounter = (words%2==0)?words:words-1;
            matcher = pattern.matcher(s);
            int difference = 0;
            while (matcher.find() && wordCounter>0) {
                newString.replace(matcher.start()-difference, matcher.end()-difference, "");
                difference += (matcher.end() - matcher.start());
                wordCounter--;
            }
            return newString;
        }).forEach(s->Writer.writeToFile(outputFilePath,true,s.toString()));
    }
}

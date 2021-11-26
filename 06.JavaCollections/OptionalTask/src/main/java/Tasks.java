import utils.FileUtil;
import utils.GetInfo;
import java.util.*;

public class Tasks {
    public static void Task1(String sourceFile, String resultFile){
        System.out.println("Reading from "+sourceFile);
        List<String> fileStrings = FileUtil.read(sourceFile);
        Collections.reverse(fileStrings);
        FileUtil.write(resultFile,false,fileStrings);
        System.out.println("Writing in the reverse order complete in file "+resultFile);
    }

    public static void Task2(){
        char[] number = (Integer.toString(GetInfo.getInt("Input the number: "))).toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character ch:number){
            stack.add(ch);
        }
        StringBuilder reverseNumber = new StringBuilder();
        for (Character ch:number){
            reverseNumber.append(stack.pop());
        }
        System.out.println("In the reverse order: ");
        System.out.println(Integer.parseInt(String.valueOf(reverseNumber)));
    }

    public static void Task3(String sourceFile, String resultFile){
        System.out.println("Reading from "+sourceFile);
        List<String> fileStrings = FileUtil.read(sourceFile);
        fileStrings.sort((Comparator<String>) (o1,o2)->o1.length()-o2.length());
        FileUtil.write(resultFile,false,fileStrings);
        System.out.println("Sort by length is complete in file "+resultFile);
    }
}

import utils.GetInfo;

public class Runner {
    public static void main(String[] args){
        String sourceFile = "src/sourceFiles/source.txt";
        String resultFile = "src/outputFiles/result.txt";
        int taskNumber = GetInfo.getInt("Please input the task number from 1 to 3: ");
        switch (taskNumber){
            case 1:Tasks.Task1(sourceFile,resultFile);
                   break;
            case 2:Tasks.Task2();
                   break;
            case 3:Tasks.Task3(sourceFile,resultFile);
                   break;
            default:
                System.out.println("Incorrect task number!");
        }
    }
}

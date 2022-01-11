import utils.GetInfo;

public class Runner {

    public static void main(String[] args){

        int taskNumber = GetInfo.getInt("Please, enter the number of the task from 1 to 3: ");
        switch (taskNumber){
            case 1:
                String sourceFilePathTask1 = "src/sourceFiles/Task1.txt";
                String outputFilePathTask1 = "src/outputFiles/Task1.txt";
                Tasks.task1(sourceFilePathTask1,outputFilePathTask1,7);
                break;
            case 2:
                String sourceFilePathTask2 = "src/sourceFiles/Task2.txt";
                String outputFilePathTask2 = "src/outputFiles/Task2.txt";
                Tasks.task2(sourceFilePathTask2,outputFilePathTask2);
                break;
            case 3:
                String sourceFilePathTask3 = "src/sourceFiles/Task3.txt";
                String outputFilePathTask3 = "src/outputFiles/Task3.txt";
                Tasks.task3(sourceFilePathTask3,outputFilePathTask3);
                break;
            default:
                System.out.println("Incorrect task number!");
        }
    }
}
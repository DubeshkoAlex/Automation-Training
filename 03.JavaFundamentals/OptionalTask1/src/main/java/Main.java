import actions.GetInfo;

public class Main {
    public static void main(String[] args) {

        int taskNumber = GetInfo.getInt("Please, enter the number of the task from 1 to 4: ");
        switch (taskNumber){
            case 1:
                Tasks.task1();
                break;
            case 2:
                Tasks.task2();
                break;
            case 3:
                Tasks.task3();
                break;
            case 4:
                Tasks.task4();
                break;
            default:
                System.out.println("Incorrect task number!");
        }
    }
}



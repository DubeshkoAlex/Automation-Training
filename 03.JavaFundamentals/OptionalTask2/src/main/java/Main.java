import actions.GetInfo;

public class Main {
    public static void main(String[] args) {
        int taskNumber = GetInfo.getInt("Please, enter the number of the task from 1 to 2: ");
        switch (taskNumber){
            case 1:
                Tasks.task1();
                break;
            case 2:
                Tasks.task2();
                break;
            default:
                System.out.println("Incorrect task number!");
        }
    }
}

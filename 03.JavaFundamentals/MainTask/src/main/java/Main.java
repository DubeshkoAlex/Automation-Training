import actions.Create;
import actions.GetInfo;

public class Main {
    public static void main(String[] args){
        int taskNumber = GetInfo.getInt("Please input the task number from 1 to 5: ");
        switch (taskNumber){
            case 1:
                Tasks.task1();
                break;
            case 2:
                Tasks.task2();
                for (int i = args.length - 1; i >= 0; i--) {
                System.out.println("args[" + i + "] is " + args[i]);
                }
                break;
            case 3:
                Tasks.task3();
                break;
            case 4:
                Tasks.task4();
                int sum=0;
                int multiply=1;
                for (int i = 0; i < args.length; i++){
                    sum = sum + Integer.parseInt(args[i]);
                    multiply*=Integer.parseInt(args[i]);
                }
                System.out.println("Arguments sum is " + sum);
                System.out.println("Arguments multiply is " + multiply);
                break;
            case 5:
                Tasks.task5();
                break;
            default:
                System.out.println("Incorrect task number!");
        }
    }
}

import java.util.Arrays;
import java.util.List;

public class Tasks {
    private static List<Student> studentsList = Arrays.asList(
            new Student(1,"Alexey","Dubeshko","Igorevich","04.06.1995","Rafieva, 51", "25 794 18 92", "MehMat",4,"23e"),
            new Student(2,"Pavel","Vinokurov","Victorovich","03.08.1991","Borovaja, 68", "25 345 13 56", "KSIS",3,"25u"),
            new Student(3,"Kirill","Viluha","Andreevich","12.06.1987","Semashko, 314", "29 444 58 00", "FRE",4,"23m"),
            new Student(4,"Georgiy","Babenia","Igorevich","24.03.1998","Rafieva, 53", "25 733 14 66", "MehMat",4,"23e"),
            new Student(5,"Alexey","Bekish","Aleksandrovich","13.12.1996","Lubimova, 151", "44 744 13 12", "FRE",4,"23m"),
            new Student(6,"Veronika","Azarko","Vladimirovna","14.12.1998","Beletskogo, 13", "44 735 17 62", "MehMat",3,"2e")
    );

    public static void task1(){
       Operations.showStudents(Operations.filterStudent(studentsList,0));
    }

    public static void task2(){
        Operations.showStudents(Operations.filterStudent(studentsList,1));
    }

    public static void task3(){
        Operations.showStudents(Operations.filterStudent(studentsList,2));
    }

    public static void task4(){
        Operations.showStudents(Operations.filterStudent(studentsList,3));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Operations {
public static void showStudents(List<Student> studentsList){
    String s = String.format("%-5s%-15s%-20s%-20s%-25s%-20s%-20s%-15s%-20s%-15s",
            "ID","First Name","Middle Name","Last Name",
            "Date of birth","Address","Phone number",
            "Faculty","Year of study","Group");
    System.out.println(s);
    System.out.println("\n");
    for (Student student: studentsList) {
        System.out.println(student);
            System.out.println("\n");
    }
}

public static List<Student> filterStudent(List<Student> studentsList, int checkBy){
        // 0 - check by faculty
        // 1 - check by faculty and year of study
        // 2 - check by date of birth
        // 3 - check by group
    String facultyName;
    int yearOfStudy;
    String year;
    String group;
    List<Student> newStudentList = new ArrayList<>();
    switch (checkBy){
        case 0:
            facultyName = GetInfo.getString("Please, input faculty name: ");
            for (Student student: studentsList) {
                if(student.getFaculty().toLowerCase(Locale.ROOT).equals(facultyName.toLowerCase(Locale.ROOT))){
                    newStudentList.add(student);
                }
            }
            break;
        case 1:
            facultyName = GetInfo.getString("Please input faculty name: ");
            yearOfStudy = GetInfo.getInt("Please, input the year of study: ");
            for (Student student: studentsList) {
                if(student.getFaculty().toLowerCase(Locale.ROOT).equals(facultyName.toLowerCase(Locale.ROOT)) && student.getYearOfStudy() == yearOfStudy){
                    newStudentList.add(student);
                }
            }
            break;
        case 2:
            year = GetInfo.getString("Please, input the year: ");
            for (Student student: studentsList) {
                if((Integer.parseInt(student.getDateOfBirth().substring(6)) > Integer.parseInt(year))){
                    newStudentList.add(student);
                }
            }
            break;
        case 3:
            group = GetInfo.getString("Please input the group name: ");
            for (Student student: studentsList) {
                if(student.getGroup().toLowerCase(Locale.ROOT).equals(group.toLowerCase(Locale.ROOT))){
                    newStudentList.add(student);
                }
            }
            break;
        default:
            System.out.println("Wrong value!");
    }
        return newStudentList;
    }
}

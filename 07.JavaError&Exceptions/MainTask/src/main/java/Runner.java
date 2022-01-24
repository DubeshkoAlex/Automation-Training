import university.Faculty;
import university.Group;
import university.Student;
import university.University;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<Faculty> faculties = initialization();

        University university = new University("BSUIR",faculties);

        university.getAverageStudentAllSubjectsMark(1);

        university.getAverageGroupAndFacultySubjectMark("FRE","240301","math");

        university.getAverageUniversitySubjectMark("math");
    }

    public static List<Faculty> initialization(){
        Student student1 = new Student(1,"Aleksandr","Petrov");
        student1.addSubject("math",10);
        student1.addSubject("phylosophy",8);
        student1.addSubject("english",8);

        Student student2 = new Student(2,"Vadim","Galygin");
        student2.addSubject("math",5);
        student2.addSubject("phylosophy",10);

        Student student3 = new Student(3,"Pavel","Volya");
        student3.addSubject("math",8);
        student3.addSubject("physics",5);
        student3.addSubject("english",9);

        Student student4 = new Student(4,"Levon","Aganezov");
        student4.addSubject("biology",7);
        student4.addSubject("phylosophy",8);
        student4.addSubject("english",8);

        Student student5 = new Student(5,"Vladimir","Vinokur");
        student5.addSubject("math",5);
        student5.addSubject("biology",10);

        Student student6 = new Student(6,"David","Tsalaev");
        student6.addSubject("math",8);
        student6.addSubject("physics",5);
        student6.addSubject("english",9);

        Student student7 = new Student(7,"Aleksandr","Shurochkin");
        student7.addSubject("math",7);
        student7.addSubject("phylosophy",8);
        student7.addSubject("english",8);

        Student student8 = new Student(8,"Vadim","Petrosyan");
        student8.addSubject("math",5);
        student8.addSubject("phylosophy",10);

        Student student9 = new Student(9,"Pavel","Zaycev");
        student9.addSubject("math",8);
        student9.addSubject("physics",5);
        student9.addSubject("english",9);

        Student student10 = new Student(10,"Levon","Charatian");
        student10.addSubject("biology",10);
        student10.addSubject("phylosophy",8);
        student10.addSubject("english",8);

        Student student11 = new Student(11,"Vladimir","Tsar");
        student11.addSubject("math",5);
        student11.addSubject("biology",10);

        Student student12 = new Student(12,"David","Tokarev");
        student12.addSubject("math",8);
        student12.addSubject("physics",5);
        student12.addSubject("english",9);

        List<Student> students1 = new ArrayList<>();
        students1.add(student1);
        students1.add(student2);

        List<Student> emptyStudents = new ArrayList<>();

        Group group1 = new Group("240301",students1);

        List<Student> students2 = new ArrayList<>();
        students2.add(student3);
        students2.add(student4);

        Group group2 = new Group("240302",students2);

        List<Group> groups1 = new ArrayList<>();
        groups1.add(group1);
        groups1.add(group2);

        List<Student> students3 = new ArrayList<>();
        students3.add(student5);
        students3.add(student6);

        Group group3 = new Group("240303",students3);

        List<Student> students4 = new ArrayList<>();
        students4.add(student7);
        students4.add(student8);

        Group group4 = new Group("240304",students4);

        List<Group> groups2 = new ArrayList<>();
        groups2.add(group3);
        groups2.add(group4);

        List<Student> students5 = new ArrayList<>();
        students5.add(student9);
        students5.add(student10);

        Group group5 = new Group("240305",students5);

        List<Student> students6 = new ArrayList<>();
        students6.add(student11);
        students6.add(student12);

        Group group6 = new Group("240306",students6);

        List<Group> groups3 = new ArrayList<>();
        groups3.add(group5);
        groups3.add(group6);

        List<Group> emptyGroups = new ArrayList<>();
        Faculty faculty1 = new Faculty("FRE",groups1);
        Faculty faculty2 = new Faculty("FITU",groups2);
        Faculty faculty3 = new Faculty("FTK",groups3);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);
        faculties.add(faculty2);
        faculties.add(faculty3);

        return faculties;
    }
}

package university;

import exceptions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class University {
    private String name;
    private List<Faculty> faculties;

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void addFaculty(Faculty faculty){
        this.faculties.add(faculty);
    }

    public void getAverageStudentAllSubjectsMark(int studentId){
        if(getFaculties().size() == 0){
            throw new CountFacultyException("There are no faculties in university");
        }
        this.faculties.forEach(faculty ->{
                if(faculty.getGroups().size()==0){
                    throw new CountGroupException("There are no groups on " + faculty.getName() + " faculty!");
                }
                faculty.getGroups().forEach(group -> {
                        if(group.getStudents().size() == 0){
                            throw new CountStudentException("There are no students in " + group.getName() + " group!");
                        }
                        group.getStudents().forEach(student -> {
                            if(student.getSubjects().size() == 0){
                                throw new CountSubjectException("The student " + student.getFirstName() + " " + student.getLastName()
                                + " with id = " + student.getId() + " doesn't have subjects");
                            }
                            BigDecimal averageMark;
                            if (student.getId() == studentId) {
                                double marksSum = (double) student.getSubjects().stream().map(subject -> {
                                    if(subject.getMark() < 0 || subject.getMark() > 10){
                                        throw new WrongMarkException("Mark should be in range from 0 to 10! Current mark is "
                                                + subject.getMark() + " (student_id = " + studentId + ")");
                                    }
                                    return subject.getMark();
                                }).reduce(Integer::sum).get();
                                double count = student.getSubjects().stream().map(Subject::getMark).count();
                                averageMark = (BigDecimal.valueOf(marksSum / count))
                                        .setScale(2, RoundingMode.HALF_UP);
                                System.out.println("Student average mark all subjects (student_id = " + studentId + "): " + averageMark);
                            }
                        });
                });
        });
    }

    public void getAverageGroupAndFacultySubjectMark(String facultyName, String groupName, String subjectName){
        if(getFaculties().size() == 0){
            throw new CountFacultyException("There are no faculties in university");
        }
        this.faculties.forEach(faculty -> {
            if(faculty.getGroups().size()==0){
                throw new CountGroupException("There are no groups on " + faculty.getName() + " faculty!");
            }
            if(faculty.getName().equals(facultyName)){
                faculty.getGroups().forEach(group -> {
                    if(group.getStudents().size() == 0){
                        throw new CountStudentException("There are no students in " + group.getName() + " group!");
                    }
                    List<Integer> sum;
                    if(group.getName().equals(groupName)){
                        sum = group.getStudents().stream().map(student -> {
                            if(student.getSubjects().size() == 0){
                                throw new CountSubjectException("The student " + student.getFirstName() + " " + student.getLastName()
                                        + " with id = " + student.getId() + " doesn't have subjects");
                            }
                            return student.getSubjects().stream().map(subject -> {
                                if(subject.getMark() < 0 || subject.getMark() > 10){
                                    throw new WrongMarkException("Mark should be in range from 0 to 10! Current mark is "
                                            + subject.getMark() + " (student_id = " + student.getId() + ")");
                                }
                                int mark = 0;
                                if (subject.getName().equals(subjectName)) {
                                    mark = subject.getMark();
                                }
                                return mark;
                            }).reduce(Integer::sum);
                        }).map(Optional::get).collect(Collectors.toList());
                        double marksSum = (double)(sum.stream().reduce(Integer::sum).get());
                        BigDecimal averageMark = (BigDecimal.valueOf(marksSum/sum.size())).setScale(2, RoundingMode.HALF_UP);
                        System.out.println("Average mark in group " + groupName + " on faculty " + facultyName + " (" + subjectName + " subject): " + averageMark);
                    }
                });
            }
        });
    }

    public void getAverageUniversitySubjectMark(String subjectName){
        if(getFaculties().size() == 0){
            throw new CountFacultyException("There are no faculties in university");
        }
        List<Integer> marks = new ArrayList<>();
        faculties.stream().forEach(faculty -> {
            if(faculty.getGroups().size()==0){
                throw new CountGroupException("There are no groups on " + faculty.getName() + " faculty!");
            }
            faculty.getGroups().stream().forEach(group -> {
                if(group.getStudents().size() == 0){
                    throw new CountStudentException("There are no students in " + group.getName() + " group!");
                }
                group.getStudents().stream().forEach(student -> {
                    if(student.getSubjects().size() == 0){
                        throw new CountSubjectException("The student " + student.getFirstName() + " " + student.getLastName()
                                + " with id = " + student.getId() + " doesn't have subjects");
                    }
                    student.getSubjects().forEach(subject -> {
                        if(subject.getMark() < 0 || subject.getMark() > 10){
                            throw new WrongMarkException("Mark should be in range from 0 to 10! Current mark is "
                                    + subject.getMark() + " (student_id = " + student.getId() + ")");
                        }
                        if(subject.getName().equals(subjectName)) {
                            marks.add(subject.getMark());
                        }
                    });
                });
            });
        });
        double marksSum = (double)(marks.stream().reduce(Integer::sum).get());
        BigDecimal averageMark = (BigDecimal.valueOf(marksSum/marks.size())).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Average mark in university (" + subjectName + " subject): " + averageMark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(name, that.name) && Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, faculties);
    }

    @Override
    public String toString() {
        return "University.University{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}

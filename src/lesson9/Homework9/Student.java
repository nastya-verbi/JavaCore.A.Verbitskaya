package lesson9.Homework9;

import java.util.List;

public class Student {
    private String student;
    private List<Course> courses;


    public Student(String student, List<Course> courses) {
        this.student = student;
        this.courses = courses;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    @Override
    public String toString() {
        return "Student{" +
                "student='" + student + '\'' +
                ", courses=" + courses +
                '}';
    }
}

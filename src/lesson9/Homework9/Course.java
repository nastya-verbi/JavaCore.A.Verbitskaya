package lesson9.Homework9;

import java.util.Objects;

public class Course {
    private String nameCourse;

    public Course(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "nameCourse='" + nameCourse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Course course = (Course) o;
        return course.nameCourse == nameCourse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCourse);
    }

}

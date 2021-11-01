package lesson9.Homework9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Anton",
                Arrays.asList(new Course("Java"),
                        new Course( "HTML"),
                        new Course("Design"))));

        studentList.add(new Student("Anastasia",
                Arrays.asList(new Course("Java"),
                        new Course("Python"),
                        new Course("JavaScript"),
                        new Course("English"))));

        studentList.add(new Student("Alicia",
                Arrays.asList(new Course("English"),
                        new Course("Biology"))));

        studentList.add(new Student("Petr",
                Arrays.asList(new Course("C++"),
                        new Course("Testing"),
                        new Course("HTML"))));

        System.out.println("Список уникальных курсов :\n" + studentList.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .distinct().collect(Collectors.toList()));

        System.out.println("Список трёх самых любознательных студентов: \n" + studentList.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3).collect(Collectors.toList()));

        Course course = new Course("Java");
        List<Student> studentList1 = studentList.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList());
        System.out.println("Список студентов, посещяющих курс " + course + ": \n" + studentList1);
    }
}

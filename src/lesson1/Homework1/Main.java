package lesson1.Homework1;

public class Main {

    public static void main(String[] args) {
        Course course = new Course(new Pool("Pool", 50),
                new Treadmill("Treadmill", 100));
        course.getCourseInfo();

        Team team = new Team("Dinamo",
                new Member("Vasya", 25),
                new Member("Petya", 23),
                new Member("Kolya", 21),
                new Member("Dima", 19));

        team.getTeamInfo();
        course.doIt(team);
        team.showResult();
    }
}

package lesson1.Homework1;

import java.util.ArrayList;


public class Course {
    private String type;
    private int leight;
    private int energyCost = (int)((Math.random() * 30) + 30);
    private Course[] courseArr;
    private static ArrayList<String> resultArr = new ArrayList<>();


    public Course(String type, int leight) {
        this.type = type;
        this.leight = leight;
    }

    public Course(Course ... coursesGiven) {
        this.courseArr = coursesGiven;
    }

    public String getType() {
        return type;
    }

    public int getLeight() {
        return leight;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public Course[] getCourseArr() {
        return courseArr;
    }

    public static ArrayList<String> getResultArr() {
        return new ArrayList<>(resultArr);
    }

    public void getCourseInfo() {
        for (Course c : courseArr) {
            System.out.println(c.toString());
        }
    }
    public String toString(){
        return String.format("Create course %s. Energy cost %d.",type, energyCost);
    }
    public void doIt(Team team) {
        for (Member member : team.getMemberArr()) {
            for (Course course : courseArr) {
                if (member.getEnergy() > course.energyCost) {
                    member.setEnergy(member.getEnergy() - course.energyCost);
                    resultArr.add(String.format("%s passed the %s. Remaining energy %d.",
                            member.getName(), course.type, member.getEnergy()));
                }
                else {
                    resultArr.add(String.format("%s failed the %s.",
                            member.getName(), course.type));
                }
            }
        }
    }
}

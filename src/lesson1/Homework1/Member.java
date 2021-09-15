package lesson1.Homework1;

public class Member {
    private String name;
    private int age;
    private int energy = (int) ((Math.random()* 20) + 80);

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String toString(){
        return "Member " + name + " age " + age + " energy " + energy;
    }
}

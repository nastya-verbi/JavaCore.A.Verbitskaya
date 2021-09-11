package lesson1.Homework1;

public class Team{
    private String title;
    private Member[] memberArr;

    public Team(String title, Member ... membersGiven) {
        this.title = title;
        this.memberArr = membersGiven;
    }

    public void getTeamInfo() {
        System.out.println("Team " + this.title);
        for (Member m : memberArr) {
            System.out.println(m.toString());
        }
    }

    public Member[] getMemberArr() {
        return memberArr;
    }
    public void showResult() {
        for (String s : Course.getResultArr()) {
            System.out.println(s);
        }
    }
}

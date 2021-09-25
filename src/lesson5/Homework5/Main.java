package lesson5.Homework5;


public class Main {

    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.saveFile("newfile.csv");
        appData.loadFile("newfile.csv");
    }
}

package lesson5.Homework5;

import java.util.ArrayList;
import java.io.*;

import static java.lang.Integer.parseInt;


public class AppData {
    private String[] header;
    private Integer[][] data;

    public AppData() {
        header = new String[]{"Value 1", "Value 2", "Value 3"};
        data = new Integer[][]{{100, 200, 300}, {400, 500, 600}};
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    public void saveFile(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            writer.write(lineToString(header));

            for (Integer[] line : data) {
                writer.write(lineToString(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> String lineToString(T[] line) {
        String result = " ";

        for (int i = 0; i < line.length; i++) {
            result = result + line[i].toString();
            if (i != line.length - 1) {
                result += ";";
            }
        }
        result += "\n";
        return result;
    }

    public void loadFile(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String tmpString;
            tmpString = reader.readLine();
            if (tmpString != null) {
                header = tmpString.split(";");

                ArrayList<Integer[]> arrayList = new ArrayList<>();
                while ((tmpString = reader.readLine()) != null) {
                    String[] arr = tmpString.split(";");
                    Integer[] intArray = new Integer[arr.length];
                    for (int i = 0; i < arr.length; i++) {
                        intArray[i] = parseInt(arr[i]);
                    }
                    arrayList.add(intArray);
                }
                data = arrayList.toArray(new Integer[][]{});
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

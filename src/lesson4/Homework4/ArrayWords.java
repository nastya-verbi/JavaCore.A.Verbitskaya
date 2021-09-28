package lesson4.Homework4;

import java.util.Arrays;
import java.util.TreeSet;

public class ArrayWords {
    public static void main(String[] args) {

        String[] words = {"Желтый", "Красный", "Синий", "Белый", "Черный",
                "Желтый", "Белый", "Серый", "Коричневый", "Черный",
                "Розовый", "Синий", "Оранжевый", "Красный", "Голубой",};
        uniqueWords(words);
    }

    public static void uniqueWords(String[] arr) {
        TreeSet<String> set = new TreeSet<>(Arrays.asList(arr));
        int count = 0;
        for (String s : set) {
            for (int i = 0; i < arr.length; i++) {
                if (s.contains(arr[i])) {
                    count++;
                }
            }
            System.out.println(s + " - " + count);
            count = 0;
        }
    }
}

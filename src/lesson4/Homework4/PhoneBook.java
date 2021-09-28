package lesson4.Homework4;

import java.util.HashMap;

public class PhoneBook {

    public static HashMap<String, String> phoneBook = new HashMap<>();

    public static void add(String name, String phone) {
        String sumPhone = " ";
        if (phoneBook.containsKey(name) && !phoneBook.containsValue(phone)) {
            sumPhone = phoneBook.get(name) + " " + phone;
            phoneBook.put(name, sumPhone);
        } else phoneBook.put(name, phone);
    }

    public static void get(String name) {
        if (!phoneBook.containsKey(name)) {
            System.out.println("Name " + name + " does not exist in the phonebook");
        } else System.out.println(name + " " + phoneBook.get(name));
    }

    public static void main(String[] args) {
        add("Anton", "89657778899");
        add("Anton", "89657778888");
        add("Vasya", "89657778899");
        add("Petya", "89657778899");
        add("Kolya", "89657778899");

        get("Anton");
        get("Vasya");
        get("Petya");
        get("Kolya");
        get("Dima");
    }
}

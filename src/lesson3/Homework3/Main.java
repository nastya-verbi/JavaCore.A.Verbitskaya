package lesson3.Homework3;

public class Main {

// Задание 1.

    public static void swap(Object[] arr, int index1, int index2 ) {
        Object tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void printArr( Object[] arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{1, 5};
        printArr(intArr);
        swap(intArr, 0, 1);
        printArr(intArr);
        System.out.println("---------------------------------------");
        String[] strArr = new String[]{"loly", "pop"};
        printArr(strArr);
        swap(strArr, 0 , 1);
        printArr(strArr);
        System.out.println("---------------------------------------");

// Задание 2.

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.addFruit(new Apple(), new Apple(), new Apple());
        orangeBox.addFruit(new Orange());
        System.out.println(appleBox.toString());
        System.out.println(orangeBox.toString());

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox1 = new Box<>();
        appleBox.replaceFruit(appleBox1);
        System.out.println(appleBox.toString());
        System.out.println(appleBox1.toString());
    }
}
package lesson2.Homework2;

public class MyArraySizeException extends Exception{
    MyArraySizeException() {
        super("Массив должен быть размером [4 x 4]");
    }
}

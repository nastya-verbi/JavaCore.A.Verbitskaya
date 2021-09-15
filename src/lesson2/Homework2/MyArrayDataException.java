package lesson2.Homework2;

public class MyArrayDataException extends Exception{
    MyArrayDataException(int i, int j) {
        super(String.format("В ячейке [%d, %d] неверные данные", i, j));
    }
}

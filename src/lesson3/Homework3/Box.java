package lesson3.Homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitBox;

    public Box() {
        fruitBox = new ArrayList<>();
    }

    public void addFruit(T... fruit) {
        fruitBox.addAll(Arrays.asList(fruit));
    }

    public float getWeight() {
        float sum = 0;
        for (T f : fruitBox) {
            sum += f.getWeight();
        }
        return sum;
    }

    public String toString() {
        return String.format("Size: %d", fruitBox.size());
    }

    public boolean compare(Box<?> box) {
        return Math.abs(box.getWeight() - this.getWeight()) < 0.00001;
    }

    public Box<T> replaceFruit(Box<T> box) {
        box.fruitBox.addAll(this.fruitBox);
        fruitBox.clear();
        return box;
    }

}

package ru.progwards.java2.lessons.generics;

import java.util.ArrayList;
import java.util.List;

public class FruitBox <T extends Fruit> extends ArrayList{

    public void addF(Fruit item) {
        if(isEmpty())
            add(item);
        else
        if (get(0).getClass().equals(item.getClass()))
            add(item);
    }

    public float getWeight() {
        if (this.size() == 0) return 0;
        T fruit = (T)get(0);
        float result = size() * fruit.getWeight();
        return result;
    }

    public void moveTo(FruitBox item){
        if (get(0).getClass().equals(item.get(0).getClass())) {
            item.addAll(this);
            clear();
        }else
            throw new UnsupportedOperationException();
    }

    public int compareTo(FruitBox item) {
        if (getWeight() < item.getWeight()) {
            return -1;
        }
        if (getWeight() == item.getWeight()) {
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();

        FruitBox box1 = new FruitBox();
        box1.addF(a1);
        FruitBox box2 = new FruitBox();
        box2.addF(o1);
        box2.addF(o2);
        System.out.println(box1.compareTo(box2));
        System.out.println("box1="+box1.getWeight());
        System.out.println("box2="+box2.getWeight());
    }
}

class Fruit {
    public float getWeight() {
        return 0;
    }
}

class Apple extends Fruit {
    @Override
    public float getWeight() {
        return 1.0f;
    }
}

class Orange extends Fruit {
    @Override
    public float getWeight() {
        return 1.5f;
    }
}


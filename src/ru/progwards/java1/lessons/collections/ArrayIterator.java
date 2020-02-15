package ru.progwards.java1.lessons.collections;

import java.util.Iterator;

// Сделать итератор по одномерному массиву, реализовать методы hasNext() и next().
public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int index = 0;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return array.length>index;
    }

    @Override
    public T next() {
        return index < array.length ? array[index++] : null;
    }

    public static void main(String[] args) {
        Integer[] newArray = {0, 11, 1, 3, 4, 10, 7, 1};
        ArrayIterator<Integer> iterator = new ArrayIterator(newArray);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


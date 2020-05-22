package ru.progwards.java2.lessons.generics;

import java.util.Arrays;

public class DynamicArray<T> {

    private T[] arrD;
    private int size = 1;

    DynamicArray() {
        arrD = (T[]) new Object[size];
    }

    public void arrX (){
        if (arrD.length == size) {
            arrD = Arrays.copyOf(arrD, size() * 2);
        }
    }

    public void add(T item) {
        arrX();
        arrD[size-1] = item;
        size++;
    }

    public void insert(int pos, T num) {
        arrX();
        T[] newArray = (T[]) new Object[size()+1];
        System.arraycopy(arrD, 0, newArray, 0, arrD.length);
        newArray[pos] = num;
        System.arraycopy(arrD, pos, newArray, pos + 1, arrD.length - pos);
        arrD = Arrays.copyOf(newArray, newArray.length);
        size++;
    }

    public void remove(int pos) {
        if (pos<=arrD.length-1) {
            T[] newArray = (T[]) new Object[size()-1];
            System.arraycopy(arrD, 0, newArray, 0, arrD.length - 1);
            System.arraycopy(arrD, pos + 1, newArray, pos, arrD.length - pos - 1);
            arrD = Arrays.copyOf(newArray, newArray.length);
            size--;
        }
    }

    public T get(int pos) {
        return arrD[pos];
    }

    public int size() {
        return arrD.length;
    }
}

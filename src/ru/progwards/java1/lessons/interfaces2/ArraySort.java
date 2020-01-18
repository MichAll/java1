package ru.progwards.java1.lessons.interfaces2;

public class ArraySort {

    public static void sort(Comparable<Number>[] a) {
        Comparable<Number> newMass;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(((Number)a[j]))>0){
                    newMass = a[i];
                    a[i] = a[j];
                    a[j] = newMass;
                }
            }
        }
        System.out.println(java.util.Arrays.toString(a));
    }
    public static void main(String[] args) {
        Comparable<Number> [] mass = new Number[]{new IntNumber(3), new IntNumber(1),new IntNumber(4)};
        sort(mass);
        mass = new Number[]{new DoubleNumber((double)3), new DoubleNumber((double)1),new DoubleNumber((double)4)};
        sort(mass);
    }
}

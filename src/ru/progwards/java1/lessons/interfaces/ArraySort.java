package ru.progwards.java1.lessons.interfaces;

public class ArraySort implements CompareWeight {

    public CompareResult compareWeight(CompareWeight smthHasWeigt){
        return CompareResult.EQUAL;
    }

    public static void sort(CompareWeight[] a) {

    }

    public static void sort(int[] a) {
        int posMass;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    posMass = a[i];
                    a[i] = a[j];
                    a[j] = posMass;
                }
            }
        }
        System.out.println(java.util.Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] mass = new int[]{8, 2, 9, 3, 0, 7, 6, 4, 1};
        sort(mass);
    }
}

package ru.progwards.java2.lessons.generics;

import java.util.Arrays;

public class ArraySort {
    public static <T extends Comparable> void sort(T... args) {
        T posMass;
        for (int i = 0; i < args.length; i++) {
            for (int j = i + 1; j < args.length; j++) {
                if (args[i].compareTo(args[j]) > 0) {
                    posMass = args[i];
                    args[i] = args[j];
                    args[j] = posMass;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] mass = {8, 2, 9, 3, 0, 7, 6, 4, 1};
        sort(mass);
        System.out.println(Arrays.asList(mass));
    }
}

package ru.progwards.java1.lessons.arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] mass = new int[]{8, 2, 9, 3, 0, 7, 6, 4, 1};
        int posMass;
        for (int i = 0; i < mass.length; i++) {
            for (int j = i + 1; j < mass.length; j++) {
                if (mass[i] > mass[j]) {
                    posMass = mass[i];
                    mass[i] = mass[j];
                    mass[j] = posMass;
                }
            }
        }
        System.out.println(java.util.Arrays.toString(mass));
    }
}

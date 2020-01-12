package ru.progwards.java1.lessons.interfaces;

public class ArraySort {
//Для класса ArraySort из задачи 2 урока 6 переделать сортировку массива целых чисел
//на сортировку через интерфейс CompareWeight public static void sort(CompareWeight[] a)
    public static void sort(CompareWeight[] a) {
        CompareWeight posMass;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (((Animal)a[i]).getWeight() > ((Animal)a[j]).getWeight()) {
                    posMass = a[i];
                    a[i] = a[j];
                    a[j] = posMass;
                }
            }
        }
    }

    public static void main(String[] args) {
        CompareWeight[] mass = {new Animal(200.5), new Animal(10.3), new Animal(300.0)};
        sort(mass);
    }
}

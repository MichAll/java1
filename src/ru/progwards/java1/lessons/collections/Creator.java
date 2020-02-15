package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Creator {

// создать коллекцию и заполнить последовательностью четных возрастающих чисел начиная с 2,
// количество элементов в коллекции n
    public static Collection<Integer> fillEven(int n) {
        List<Integer> list1 = new ArrayList();
        for (int i = 1; i <= n; i++) {
            list1.add(i * 2);
        }
        return list1;
    }

 // создать коллекцию и заполнить последовательностью нечетных убывающих чисел,
// минимальное число в коллекции 1, количество элементов в коллекции n*3
    public static Collection<Integer> fillOdd(int n) {
        List<Integer> list2 = new ArrayList();
        for (int i = n * 3; i >= 1; i--) {
            if (i % 2 != 0) list2.add(i);
        }
        return list2;
    }

// создать коллекцию и заполнить ее тройками чисел. Каждая тройка создается по алгоритму:
// первое число тройки - индекс числа в коллекции,
// второе - индекс в квадрате, третье - индекс в кубе, количество элементов в коллекции n*3
    public static Collection<Integer> fill3(int n) {
        List<Integer> list3 = new ArrayList();
        for (int i = 0; i < n; i++) {
            list3.add(i*3, i);
            list3.add(i*3+1, i*i);
            list3.add(i*3+2,i*i*i);
        }
        return list3;
    }

    public static void main(String[] args) {
        System.out.println(fillEven(10).toString());
        System.out.println(fillOdd(10).toString());
        System.out.println(fill3(10).toString());
    }
}

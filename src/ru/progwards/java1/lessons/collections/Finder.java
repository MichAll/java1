package ru.progwards.java1.lessons.collections;

import javax.naming.Name;
import java.util.*;

public class Finder {
    // найти 2 соседних числа в коллекции сумма которых минимальна,
// вернуть коллекцию, содержащую индексы этих чисел
    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        List<Integer> listNew = new ArrayList();
        listNew.add(0);
        listNew.add(0);
        List<Integer> listOld = new ArrayList(numbers);
        if (numbers.size() > 1) {
            int summa = listOld.get(0) + listOld.get(1);
            for (int i = 0; i < listOld.size() - 1; i++) {
                if (summa > listOld.get(i) + listOld.get(i + 1)) {
                    listNew.set(0, i);
                    listNew.set(1, i + 1);
                }
            }
        }
        return listNew;
    }

    // найти локальные максимумы - числа, которые больше соседа справа и слева.
// Первый и последний элемент коллекции не может являться локальным  максимумом,
// вернуть коллекцию, содержащую значения этих максимумов
    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        List<Integer> listNew = new ArrayList();
        List<Integer> listOld = new ArrayList(numbers);
        if (numbers.size() > 2) {
            for (int i = 1; i < listOld.size() - 1; i++) {
                if (listOld.get(i - 1) < listOld.get(i) && listOld.get(i) > listOld.get(i + 1)) {
                    listNew.add(listOld.get(i));
                }
            }
        } else listNew.add(0);
        return listNew;
    }

    // проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный
    public static boolean findSequence(Collection<Integer> numbers) {
        Collection<Integer> collNew = new ArrayList();
        for (int i = 1; i <= numbers.size(); i++) collNew.add(i);
            if (numbers.containsAll(collNew) == false) return false;
//              if (numbers.contains(i) == false)
//                return false;

        return true;
    }

    // найдите максимальное количество повторяющихся подряд элементов.
// Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
// При равенстве максимального количества у разных повторяющихся элементов,
// вернуть результат для элемента, повторяющаяся последовательность которого началась с наименьшего индекса.
    public static String findSimilar(Collection<String> names) {
        String str = ""; String nameMax = "";
        if (names.isEmpty() == false) {
            int i = 1; int j = 1;
            for (String x : names) {
                System.out.println(x);
                if (x.compareTo(str) == 0) {
                    i++;
                    System.out.println(i);
                }else {
                    if (j < i) {
                        j = i;
                        nameMax = str;
                    }
                    str = x; i = 1;
                }
            }
            str = nameMax+":"+j;
        }
        return str;
    }

    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList();
        //coll.add(1);coll.add(7);coll.add(3);coll.add(5);coll.add(4);
        for (int i = 10; i >= 1; i--) {
            coll.add(i);
        }
        System.out.println(coll.toString());
        System.out.println(findMinSumPair(coll).toString());
        System.out.println(findLocalMax(coll).toString());
        System.out.println(findSequence(coll));
        Collection<String> collNames = new ArrayList();
        collNames.add("Name");
        collNames.add("Name");
        collNames.add("Valya");
        collNames.add("Valya");
        collNames.add("Valya");
        collNames.add("Buch");
        collNames.add("Buch");
        collNames.add("Name");
        collNames.add("Name");
        collNames.add("Name");
        System.out.println(findSimilar(collNames));
    }
}

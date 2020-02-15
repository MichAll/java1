package ru.progwards.MichAll;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class T12 {
    public List<Integer> listAction(List<Integer> list){
        list.remove(Collections.min(list));
        list.add(0,list.size());
        list.add(2,Collections.max(list));

        return list;
    }
// удаляет из списка элементы, значение которых меньше суммы, деленной на 100 (целочисленное деление)
    public List<Integer> filter(List<Integer> list) {
        int result = 0;
        for (Integer i : list)
            result +=i;
        for (int i=0; i<list.size(); i++) {
            if ((result / 100) <= list.get(i)){
                list.remove(i);
                i--;
            }
        }
        return list;
    }
// заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
    public void iterator3(ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            if (n % 3 == 0)
                iterator.set(iterator.previousIndex());
        }
    }
}

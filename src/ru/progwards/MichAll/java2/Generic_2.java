package ru.progwards.MichAll.java2;

import ru.progwards.java1.lessons.interfaces.CompareWeight;

import java.util.ArrayList;
import java.util.List;

public class Generic_2 {
    enum CompareResult {LESS, EQUAL, GREATER};
    public static <T extends Comparable> CompareResult compare (T o1, T o2){
        switch (o1.compareTo(o2)){
            case -1 : return CompareResult.LESS;
            case 0 : return CompareResult.EQUAL;
            default : return CompareResult.GREATER;
        }
    }
    public static <T> void swap(List<T> list, int x, int y) {
        T tmp;
        tmp = (T) list.get(x);
        list.set(x, list.get(y));
        list.set(y, tmp);
    }
    public static <T> List from(T[] arr){
        ArrayList<T> list = new ArrayList<>();
        for (T element : arr)
            list.add(element);
        return list;
    }
}

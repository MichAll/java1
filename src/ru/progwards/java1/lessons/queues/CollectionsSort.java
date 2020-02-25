package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

// - переделать алгоритм из класса ArraySort из ДЗ про массивы, на коллекции.
// Не использовать встроенные методы сортировок
    public static void mySort(Collection<Integer> data) {
        List<Integer> list = new ArrayList<>(data);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    Collections.swap(list,i, j);
                }
            }
        }
        data.clear();
        data.addAll(list);
    }

//  по следующему алгоритму
//- создать новую коллекцию
//- найти минимальный элемент с использованием функции min()
//- переместить его в новую коллекцию
//- делать так до тех пор, пока все элементы не окажутся в новой коллекции
//- скопировать новую коллекцию в старую
    public static void minSort(Collection<Integer> data) {
        List<Integer> list = new ArrayList<>();
        List<Integer> listData = new ArrayList<>(data);
        while (! listData.isEmpty()){
            list.add(Collections.min(listData));
            listData.remove(Collections.min(listData));
        }
        data.clear();
        data.addAll(list);
    }
// используя метод sort из Collections
    public static void collSort(Collection<Integer> data) {
        List<Integer> list = new ArrayList<>(data);
        Collections.sort(list);
        data.clear();
        data.addAll(list);
    }
// в котором сравнить производительность методов и вернуть их имена,
// отсортированные в порядке производительности, первый - самый быстрый.
// В случае равенства производительности каких-то методов, возвращать их названия в алфавитном порядке.
    public static Collection<String> compareSort(){
        List<Integer> massData = new ArrayList<>();
        int countEl = 99;
        Random rnd = new Random();
        for (int i=0; i< countEl; i++)
            massData.add(rnd.nextInt());
        long start = System.currentTimeMillis();
        mySort(massData);
        System.out.println(System.currentTimeMillis()-start);
        ListSort list1 = new ListSort("mySort",System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        minSort(massData);
        System.out.println(System.currentTimeMillis()-start);
        ListSort list2 = new ListSort("minSort",System.currentTimeMillis()-start);
        start = System.currentTimeMillis();
        collSort(massData);
        System.out.println(System.currentTimeMillis()-start);
        ListSort list3 = new ListSort("collSort",System.currentTimeMillis()-start);
        TreeSet<ListSort> treeSet = new TreeSet<>(new Comparator<ListSort>() {
            @Override
            public int compare(ListSort o1, ListSort o2) {
                if (o1.time>o2.time) return 1;
                else if (o1.time<o2.time) return -1;
                else return o1.list.compareTo(o2.list);
            }
        });
        treeSet.addAll(List.of(list1, list2, list3));
        List<String> result = new ArrayList(treeSet);
        return result;
    }

    public static class ListSort implements Comparable<ListSort>{
        private String list;
        private long time;

        public ListSort (String list, long time) {
            this.list = list;
            this.time = time;
        }
        @Override
        public String toString() {
            return (list);
        }
        @Override
        public int compareTo(ListSort o) {
            return Long.compare(this.time,o.time);
        }
    }
    public static void main(String[] args) {
        System.out.println(compareSort());
    }

}

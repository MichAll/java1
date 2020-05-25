package ru.progwards.java2.lessons.basetypes;

import java.util.Iterator;

/*
Реализовать класс BiDirList - двунаправленный связный список
Методы
1.1 public void addLast(T item) - добавить в конец списка
1.2 public void addFirst(T item)- добавить в начало списка
1.3 public void remove(T item) - удалить
1.4 public void at(int i) - получить элемент по индексу
1.5 public int size() - получить количество элементов
1.6 public static<T> BiDirList<T> from(T[] array) - конструктор из массива
1.7 public static<T> BiDirList<T> of(T...array) -  конструктор из массива
1.8 public static void toArray(T[] array) - скопировать в массив
1.9 public Iterator<BiDirList<T>> getIterator() - получить итератор
 */
public class BiDirList<T> {
    class ListItem<T> {
        private T item;
        private ListItem<T> next;
        private ListItem<T> prev;

        ListItem(T item) { this.item = item; }

        T getItem() { return item; }

        void setNext(ListItem<T> item) { next = item; }

        ListItem<T> getNext() { return next; }

        void setPrev(ListItem<T> item) { prev = item; }

        ListItem<T> getPrev() { return prev; }
    }

    private ListItem<T> head;
    private ListItem<T> tail;

    ListItem<T> getHead(){ return head;}
    ListItem<T> getTail(){ return tail;}

    public void addLast(T item) {
        ListItem<T> nI = new ListItem<T>(item);
        if (head == null) {
            head = nI;
            tail = nI;
        } else {
            tail.setNext(nI);
            nI.setPrev(tail);
            tail = nI;
        }
    }
    public void addFirst(T item) {
        ListItem<T> nI = new ListItem<T>(item);
        if (head == null) {
            head = nI;
            tail = nI;
        } else {
            nI.setNext(head);
            head.setPrev(nI);
            head = nI;
        }
    }
    public void remove(T item) {
        ListItem<T> list = head;
        while (list != null) {
            if (list.item == item){
                if (list.next != null)
                    list.next.prev = list.prev;
                else
                    tail = list.prev;
                if (list.prev != null)
                    list.prev.next = list.next;
                else
                    head = list.next;
            }
            list =list.next;
        }
    }
    public void at(int i) {
        if (i>=0 || i < size()) {
            ListItem<T> list = head;
            int y =0;
            while (list != null && i!=y) {
                list = list.next;
                y++;
                System.out.println(list.item);
            }
        }
    }
    public int size() {
        int size = 0;
        ListItem<T> list = head;
        while (list != null) {
            size++;
        }
        return size;
    }
    public static<T> BiDirList<T> from(T[] array) {
        BiDirList<T> list = new BiDirList<T>();
        for (T item : array) {
            list.addLast(item);
        }
        return list;
    }
    public static<T> BiDirList<T> of(T...array) {
        BiDirList<T> list = new BiDirList<T>();
        for (T item : array) {
            list.addLast(item);
        }
        return list;
    }
//    public static void toArray(T[] array) {
//    }

//    public Iterator<BiDirList<T>> getIterator(){
//    }

    public static void main(String[] args) {
        BiDirList<Integer> list = new BiDirList<>();
        list.addFirst(3);
        list.addFirst(2);
        list.addLast(4);
        list.addLast(5);
        list.addFirst(1);
        list.at(2);
        list.remove(1);
        list.remove(5);
        BiDirList<Integer>.ListItem<Integer> currentH = list.getHead();
        while (currentH != null) {
           System.out.println(currentH.getItem());
           currentH = currentH.getNext();
        }
        System.out.println();
        BiDirList<Integer>.ListItem<Integer> currentT = list.getTail();
        while (currentT != null) {
            System.out.println(currentT.getItem());
            currentT = currentT.getPrev();
        }

    }
}

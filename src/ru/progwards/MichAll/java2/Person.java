package ru.progwards.MichAll.java2;

import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
    }
    void sortAndPrint(List<Person> list) {
        list.sort(Comparator.comparing(a -> a.age));
        list.forEach(System.out::println);
    }
    int sumSequence(int n) {
        System.out.println("прямой ход, n = " + n); int result = 0;
        if (n == 1)
            result = n;
        else
            result = sumSequence(n - 2) + n;
        System.out.println(result);
        System.out.println("обратный ход, n = " + n);
        return result;
        //return sumSequence(n-2)+n;
    }
    String reverseChars(String str) {
        if (str.isEmpty())
            return "";
        return reverseChars(str.substring(1))+str.charAt(0);
    }

    public static void main(String[] args) {
        Person x = new Person("XYZ", 5);
        //System.out.println(x.sumSequence(5));
        System.out.println(x.reverseChars("12345"));
    }
}
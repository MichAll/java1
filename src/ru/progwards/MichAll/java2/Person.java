package ru.progwards.MichAll.java2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    private void setName(String name) {
        this.name = name;
    }
    void callSetName(Person person, String name){
        Class clazz = person.getClass();
        try {
            Method method = clazz.getDeclaredMethod("setName", String.class);
            method.setAccessible(true);
            method.invoke(person,name);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Person x = new Person("XYZ", 5);
        x.callSetName(x, "Vova");
        //System.out.println(x.sumSequence(5));
        //System.out.println(x.reverseChars("12345"));
    }
}
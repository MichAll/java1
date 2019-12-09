package ru.progwards.MichAll;

public class Test {
    static double fractional(double num) {
        int int1 = (int)num;
        double double1 = num - int1;
        return (double1);
    }
    public static void main(String[] args) {
        double num = 1.53;
        System.out.println(fractional(num));
    }
}
package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static boolean isTriangle(int a, int b, int c) {
        return (a < (b+c) & b < (a+c) & c < (a+b));
    }

    public static boolean isRightTriangle(int a, int b, int c) {
        return (a*a == (b*b+c*c) | b*b == (a*a+c*c) | c*c == (a*a+b*b));
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        return (a==b || b==c || c==a);
    }

    public static void main(String[] args) {
        System.out.println(isTriangle(4, 2, 3));
        System.out.println(isRightTriangle(5, 12, 13));
        System.out.println(isIsoscelesTriangle(5, 4, 2));
    }

}

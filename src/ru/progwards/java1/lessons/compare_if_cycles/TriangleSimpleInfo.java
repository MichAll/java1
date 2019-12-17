package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    public static int maxSide(int a, int b, int c) {
        int sideMax;
        if (a >= b & a >= c)
            sideMax = a;
        else if ((b >= a) & (b >= c))
             sideMax = b;
        else
             sideMax = c;
        return sideMax;
    }

    public static int minSide(int a, int b, int c) {
        int sideMin;
        if (a <= b & a <= c)
            sideMin = a;
        else if ((b <= a) & (b <= c))
            sideMin = b;
        else
            sideMin = c;
        return sideMin;
    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {
        return (a == b && a == c);
    }

    public static void main(String[] args) {
        System.out.println(maxSide(10, 9, 10));
        System.out.println(minSide(8, 8, 10));
        System.out.println(isEquilateralTriangle(3, 4,3));
    }
}

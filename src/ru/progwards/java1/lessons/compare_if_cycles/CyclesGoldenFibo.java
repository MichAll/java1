package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    static int elementFibo1 = 0;
    static int elementFibo2 = 1;

    public static boolean containsDigit(int number, int digit) {
        boolean contDig = false;
        int newNumber = number;
        do {
            if (newNumber % 10 == digit) {
                contDig = true;
                break;
            } else
                newNumber=newNumber/10;
        }while (newNumber>0);
        return contDig;
    }

    public static int fiboNumber(int n) {
        if (n!=1) {
            n = elementFibo2 + elementFibo1;
            elementFibo1=elementFibo2;
            elementFibo2 = n;
        }
        return n;
    }
    public static boolean isGoldenTriangle(int a, int b, int c) {
        boolean goldTriangle = false;
        if (a==b || b==c || c==a) {
            int sideMax;
            int sideMin;
            if (a >= b & a >= c)
                sideMax = a;
            else if ((b >= a) & (b >= c))
                sideMax = b;
            else
                sideMax = c;
            if (a <= b & a <= c)
                sideMin = a;
            else if ((b <= a) & (b <= c))
                sideMin = b;
            else
                sideMin = c;

            double maxMin = (double)sideMax / (double)sideMin;
            if (maxMin >= 1.61703 & maxMin <= 1.61903) {
                goldTriangle = true;
            }
        }
        return (goldTriangle);
    }

    public static void main(String[] args) {
        System.out.println(containsDigit(10, 0));

        for (int i=1; i<=15; i++) {
            System.out.print("n = " + i +" число ");
            System.out.println(fiboNumber(i));
        }

        for (int i=1; i<=100; i++) {
            int a = i; int b = i; int c = (int)(i / 1.61803);
            boolean goldTri = isGoldenTriangle(a, b, c);
            if (goldTri == true) {
                System.out.println(goldTri);
                System.out.println(a + " " + c);
            }
        }
    }
}

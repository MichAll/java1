package ru.progwards.MichAll;

public class Task2 {
    public static void printJava() { //1.
        String str1;
        String str2;
        String str3;
        str1="Хорошо идут дела";
        str2="Изучаю Java я!";
        str3=" ";
        System.out.println(str1);
        System.out.println(str2);
        System.out.print(str1);
        System.out.print(str3);
        System.out.println(str2);
        System.out.println(str2+str3+str1);
    }
    public static int subtraction(int x, int y) { //2.1
        System.out.println("Вызвана функция subtraction() с параметрами " + "x = " + x + ", y = " + y);
        return x - y;
    }
    public static int addition(int x, int y) { //2.2
        System.out.println("Вызвана функция addition() с параметрами " + "x = " + x + ", y = " + y);
        return x + y;
    }
    public static int multiplication(int x, int y) { //2.3
        System.out.println("Вызвана функция multiplication() с параметрами " + "x = " + x + ", y = " + y);
        return x * y;
    }
    public static void calculation() { //2.4
        int a;
        int b;
        int c;
        a = 34;
        b = 55;
        System.out.print("a = ");
        System.out.println(a);
        System.out.print("b = ");
        System.out.println(b);
        c = addition(a,b);
        System.out.print("a + b = ");
        System.out.println(c);
        c = subtraction(a,b);
        System.out.print("a - b = ");
        System.out.println(c);
        c = multiplication(a,b);
        System.out.print("a * b = ");
        System.out.println(c);
    }
    public static void main (String[] args) { //3
        printJava();
        subtraction(45,12);
        subtraction(23,55);
        addition(128,787);
        addition(528,387);
        multiplication(124,87);
        multiplication(1528,3);
//        calculation();
    }
}

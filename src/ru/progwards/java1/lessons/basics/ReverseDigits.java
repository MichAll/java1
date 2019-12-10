package ru.progwards.java1.lessons.basics;

public class ReverseDigits { //1
    public static int reverseDigits(int number) {
        int num4 = number / 10;
        int num1 = number % 10;
        int num3 = num4 / 10;
        int num2 = num4 % 10;
        int num0 = num1 * 100 + num2 *10 + num3;
        return num0;
    }
    public static void main(String[] args) {
        int number = 125;
        System.out.println(reverseDigits(number));
    }
}

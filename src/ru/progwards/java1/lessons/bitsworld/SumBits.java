package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static int sumBits(byte value) {
        int sumRes=0;
        for (int i = 0; i < 8; ++i) {
            int res = 0b00000001 & value;
            sumRes += res;
            value >>= 1;
        }
        return sumRes;
    }

    public static void main(String[] args) {
        byte value = -128;
        System.out.println(sumBits(value));
    }
}

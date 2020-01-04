package ru.progwards.java1.lessons.bitsworld;

public class SumBits {

    public static int sumBits(byte value) {
        int sumRes=0;
        for (int i = 1; i < 8; ++i) {
            int res = 0b00000001 & value;
            sumRes += res;
            value >>= 1;
        }
        return sumRes;
    }

    public static void main(String[] args) {
        byte value = 0b01111111;
        System.out.println(sumBits(value));
    }
}

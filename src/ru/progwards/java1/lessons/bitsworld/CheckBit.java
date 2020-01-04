package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {

    public static int checkBit(byte value, int bitNumber) {
        int result = 0;
        value >>=bitNumber;
        result = 0b1 & value;
        return result;
    }

    public static void main(String[] args) {
        byte value = 115;
        System.out.println(Integer.toBinaryString(value));
        int bitNumber = 4;
        System.out.println("значение бита № "+bitNumber+" = "+checkBit(value, bitNumber));
    }

}


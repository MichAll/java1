package ru.progwards.java1.lessons.bitsworld;

public class Binary {

    byte num;

    public Binary(byte num) {
        this.num = num;
    }

    public String toString(){
        String result="";
        for (int i = 0; i < 8; ++i) {
            int res = 0b00000001 & num;
            result = res + result;
            num >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        byte num = 8;
        System.out.println(Integer.toBinaryString(num));
        Binary binNew = new Binary(num);
        System.out.println(binNew.toString());
    }
}

package ru.progwards.java1.lessons.test;

public class Test1 {
//    public byte value ;
//
//    public int resX(byte value) {
//
//        value <<= 6;
//        value &= 0b1111111;
//        int result = value;
//        if (result != 0)
//            result = 1;
//
//        return result;
//    }

    enum Grade {VERYBAD, BAD, SATISFACTORILY, GOOD, EXCELLENT, NOTDEFINED}

    static Grade intToGrade(int grade) {
        switch (grade) {
            case 1: return Grade.VERYBAD;
            case 2: return Grade.BAD;
            case 3: return Grade.SATISFACTORILY;
            case 4: return Grade.GOOD;
            case 5: return Grade.EXCELLENT;
            default: return Grade.NOTDEFINED;
        }
    }
    public static void main(String[] args) {
        System.out.println(intToGrade(4));
    }
}

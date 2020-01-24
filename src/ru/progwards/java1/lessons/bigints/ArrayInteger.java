package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    //    инициализирует класс, с максимальной точностью n цифр (размер массива)
    ArrayInteger(int n) {
        digits = new byte[n];
    }

    //    установить свое значение, взяв его из value (уложить BigInteger во внутренний массив)
    void fromInt(BigInteger value) {
        if (value.toString().length()>digits.length){
            digits = new byte[value.toString().length()];
        }
        for (int i = 0; i < digits.length; i++) {
            digits[i] = value.mod(BigInteger.TEN).byteValue();
            value = value.divide(BigInteger.TEN);
        }
    }
    //    привести свое значение к BigInteger (преобразовать из массива в BigInteger)
    BigInteger toInt() {
        int i = 0;
        BigInteger value = BigInteger.ZERO;
        while (i < digits.length) {
            value = value.add(BigInteger.valueOf(digits[i]).multiply(BigInteger.TEN.pow(i)));
            i++;
        }
        return value;
    }
//сложить 2 числа, не используя BigInteger, а  используя массив digits, результат поместить в экземпляр ArrayInteger,
// у которого был вызван метод. При переполнении вернуть false, при этом само число сбросить в 0
    boolean add(ArrayInteger num) {
        if (num.digits.length>digits.length){
            Arrays.fill(digits, (byte) 0);
            return false;
        }
        byte num10 = 0;
        for (int i=0; i < digits.length; i++) {
            byte perMen = 0;
            if (i < num.digits.length) {
                perMen = (byte) (((digits[i] + num.digits[i]) % 10) + num10);
                num10 = (byte) ((digits[i] + num.digits[i]) / 10);
            } else {
                if (num10 > 0) {
                    perMen = (byte) ((digits[i] + num10) % 10);
                    num10 = (byte) (digits[i] / 10);
                }
             }
            digits[i] = perMen;
        }
        if (num10 > 0) {
            Arrays.fill(digits, (byte) 0);
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayInteger ai1 = new ArrayInteger(3);
        ai1.fromInt(new BigInteger("6789"));
        ArrayInteger ai2 = new ArrayInteger(3);
        ai2.fromInt(new BigInteger("1589"));
        System.out.println(ai1.add(ai2));
//        Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
//        Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
//        Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
    }
}

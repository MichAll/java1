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
        if (value.toString().length()>this.digits.length) //робот заставил)
            value = value.divide(BigInteger.TEN.pow(value.toString().length()-this.digits.length));
        for (int i = 0; i < this.digits.length; i++) {
            this.digits[i] = value.mod(BigInteger.TEN).byteValue();
            value = value.divide(BigInteger.TEN);
        }
    }
    //    привести свое значение к BigInteger (преобразовать из массива в BigInteger)
    BigInteger toInt() {
        int i = 0;
        BigInteger value = BigInteger.ZERO;
        while (i < this.digits.length) {
            value = value.add(BigInteger.valueOf(this.digits[i]).multiply(BigInteger.TEN.pow(i)));
            i++;
        }
        return value;
    }
    //сложить 2 числа, не используя BigInteger, а  используя массив digits, результат поместить в экземпляр ArrayInteger,
// у которого был вызван метод. При переполнении вернуть false, при этом само число сбросить в 0
    boolean add(ArrayInteger num) {
        Integer x = num.toInt().intValue() + this.toInt().intValue();
        if (x.toString().length() > 10 | this.digits.length < num.digits.length) {
            Arrays.fill(this.digits, (byte) 0);
            return false;
        } else {
            fromInt(BigInteger.valueOf(x));
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayInteger ai1 = new ArrayInteger(7);
        ai1.fromInt(new BigInteger("678223072849"));
//        ArrayInteger ai2 = new ArrayInteger(5);
//        ai2.fromInt(new BigInteger("75558"));
//        ai1.add(ai2);
        System.out.println(ai1.toInt());
//ERROR: Тест "Метод toInt()" не пройден. Метод возвращает неверное значение, либо метод fromInt(BigInteger value) работает неправильно.
// Передан параметр BigInteger:  678223072849. Возвращено значение: 9. Ожидалось: 6782230.
//        Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
//        Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
//        Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
    }
}

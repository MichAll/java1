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
        int x = (int) Math.log10(value.intValue()) + 1;
        for (int i = 0; i < x; i++) {
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
        Integer x = num.toInt().byteValue() + this.toInt().byteValue();
        if (x.toString().length() > 10 | this.digits.length < x) {
            Arrays.fill(this.digits, (byte) 0);
            return false;
        } else {
            fromInt(BigInteger.valueOf(x));
            return true;
        }
    }

    public static void main(String[] args) {
        ArrayInteger arrayNew = new ArrayInteger(7);
        arrayNew.fromInt(BigInteger.valueOf(1234567));
        System.out.println(arrayNew.toInt());
        ArrayInteger arrayNew1 = new ArrayInteger(8);
        arrayNew1.digits = new byte[]{2, 3, 4, 5, 7, 8, 9, 1};
        System.out.println(arrayNew.add(arrayNew1));
//        Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
//        Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
//        Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
    }
}

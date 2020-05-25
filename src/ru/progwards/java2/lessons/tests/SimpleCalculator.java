package ru.progwards.java2.lessons.tests;

public class SimpleCalculator {

    public int sum(int val1, int val2) {
        long result = (long) val1 + val2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            throw new ArithmeticException("переполнение");
        return (int) result;
    }

    public int diff(int val1, int val2) {
        long result = (long) val1 - val2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            throw new ArithmeticException("переполнение");
        return (int) result;
    }

    public int mult(int val1, int val2) {
        long result = (long) val1 * val2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            throw new ArithmeticException("переполнение");
        return (int) result;
    }

    public int div(int val1, int val2) {
        if (val2 == 0)
            throw new ArithmeticException("деление на ноль");
        long result = (long) val1 / val2;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            throw new ArithmeticException("переполнение");
        return (int) result;
    }

}

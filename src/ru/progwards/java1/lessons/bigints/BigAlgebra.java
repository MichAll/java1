package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

//алгоритм быстрого возведения в степень pow числа num в BigDecimal
    static BigDecimal fastPow(BigDecimal num, int pow){
         BigDecimal num1 = BigDecimal.ONE;
        if (pow==0) return num1;
        else
            while (pow/2 != 0){
                if (pow % 2 == 0) {
                    num = num.multiply(num);
                    pow = pow / 2;
                }
                else {
                    num1 = num1.multiply(num);
                    pow -=1;
                }
             }
        return num.multiply(num1);
    }
//алгоритм вычисления n-го числа фибоначчи в BigInteger.
    static BigInteger fibonacci(int n) {
        if (n <= 0) return BigInteger.ZERO;
        BigInteger elementFibo1 = BigInteger.valueOf(0);
        BigInteger elementFibo2 = BigInteger.valueOf(1);
        BigInteger newFibo = BigInteger.valueOf(0);
        for (int i = 1; i <= n; i++) {
            newFibo = elementFibo2.add(elementFibo1);
            if (i!=1) elementFibo1 = elementFibo2;
            elementFibo2 = newFibo;
            System.out.println(newFibo);
        }
        return newFibo;
    }
    public static void main(String[] args) {
        System.out.println(BigAlgebra.fastPow(new BigDecimal("2.11"), 13));
        System.out.println(BigAlgebra.fibonacci(21));
    }
}

package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    static CacheInfo lastFibo;

    public static class CacheInfo {
        //public int n - число, для которого рассчитываем Фибоначчи
//public int fibo - результат расчета
        public int n;
        public int fibo;

        CacheInfo(int n, int fibo) {
            this.n = n;
            this.fibo = fibo;
        }
    }

    //проверять параметр n на совпадение с последним рассчитанным значением,
// и если совпадает - возвращать уже готовый результат.
// Если не совпадает - рассчитывать и сохранять в статической переменной lastFibo.
    public static int fiboNumber(int n) {
        if (lastFibo != null)
        if (n == lastFibo.n) return lastFibo.fibo;
        int elementFibo1 = 0;
        int elementFibo2 = 1;
        int newFibo = 0;
        for (int i = 1; i <= n; i++) {
            newFibo = elementFibo2 + elementFibo1;
            if (i!=1) elementFibo1 = elementFibo2;
            elementFibo2 = newFibo;
        }
        lastFibo = new CacheInfo(n, newFibo);
        return newFibo;
    }

    //возвращает lastFibo
    public static CacheInfo getLastFibo() {
        return lastFibo;
    }

    //сбрасывает lastFibo в null
    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(15));
    }
}

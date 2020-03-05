package ru.progwards.java1.lessons.maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {

    private final boolean cacheOn;
    private Map<Integer, BigDecimal> fiboCache = new HashMap<>();

// включен ли кэш. При cacheOn = true кэш работает, при cacheOn = false - выключен
    public FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;
    }

// Алгоритм работы следующий:
// в функции проверить, находится ли вычисленное значение для n в кэше, и если да - вернуть его из кэша,
// если нет - рассчитать и добавить в кэш. Учитывать значение переменной cacheOn
    public BigDecimal fiboNumber(int n){
        if (n <= 0) return BigDecimal.ZERO;
        if (cacheOn == true) {
            if (fiboCache.containsKey(n)) {
                return fiboCache.get(n);
            }else {
                BigDecimal elementFibo1 = BigDecimal.ZERO;
                BigDecimal elementFibo2 = BigDecimal.ONE;
                BigDecimal newFibo = BigDecimal.ONE;
                for (int i = 1; i <= n; i++) {
                    newFibo = elementFibo2.add(elementFibo1);
                    if (i != 1) elementFibo1 = elementFibo2;
                    elementFibo2 = newFibo;
                }
                fiboCache.put(n, newFibo);
                return newFibo;
            }
        } else {
            BigDecimal elementFibo1 = BigDecimal.ZERO;
            BigDecimal elementFibo2 = BigDecimal.ONE;
            BigDecimal newFibo = BigDecimal.ONE;
            for (int i = 1; i <= n; i++) {
                newFibo = elementFibo2.add(elementFibo1);
                if (i != 1) elementFibo1 = elementFibo2;
                elementFibo2 = newFibo;
            }
            return newFibo;
        }
    }

// устанавливает переменную fiboCache в null
    public void clearCahe() {
        fiboCache.clear();
    }
// тест для расчета чисел Фибоначчи от n = 1 до 1000 включительно и замерить разницу во времени с on = true и on = false,
// результат вывести на экран в формате "fiboNumber cacheOn=??? время выполнения ???" для cacheOn=true и cacheOn=false,
// вместо ??? вывести реальные значения в мсек.
    public static void test() {
        FiboMapCache newFiboOn = new FiboMapCache(true);
        FiboMapCache newFiboOff = new FiboMapCache(false);
        for (int y = 1; y <= 2; y++) {
            long timeOn = System.currentTimeMillis();
            for (int i = 1; i <= 1000; i++) {
                newFiboOn.fiboNumber(i);
            }
            timeOn = System.currentTimeMillis() - timeOn;
            System.out.println("fiboNumber cacheOn=true время выполнения " + timeOn);
            long timeOff = System.currentTimeMillis();
            for (int i = 1; i <= 1000; i++) {
                newFiboOff.fiboNumber(i);
            }
            timeOff = System.currentTimeMillis() - timeOff;
            System.out.println(("fiboNumber cacheOn=false время выполнения " + timeOff));
        }
    }

    public static void main(String[] args) {
        test();
    }
// Кеш для чисел Фибоначчи на Map.
// Кеш имитирует таковой на сервере, когда идут запросы со случайными параметрами от разных пользователей.
// Сам алгоритм чисел Фибоначчи - это просто пример некоего алгоритма, который долго работает,
// в сравнении с вытаскиванием значения из кэша.
// Считается, что кеш ничего не знает об алгоритме, и умеет только сохранять и доставать значения по ключу.
}

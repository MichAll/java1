package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.SimpleCalculator;

public class SimpleCalculatorTestDiv0 {
    static SimpleCalculator calc;

    @BeforeClass
    public static void init() {
        calc = new SimpleCalculator();
    }

    @Test(expected = ArithmeticException.class)
    public void testDiv0() {
        calc.div(1, 0);
    }
}

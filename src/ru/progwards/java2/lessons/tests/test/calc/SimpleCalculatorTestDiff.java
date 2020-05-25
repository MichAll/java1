package ru.progwards.java2.lessons.tests.test.calc;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.SimpleCalculator;

import static org.junit.Assert.*;
import java.util.Arrays;


@RunWith(Parameterized.class)
public class SimpleCalculatorTestDiff {

    static SimpleCalculator calc;

    @BeforeClass
    public static void init() {
        calc = new SimpleCalculator();
    }

    @Parameterized.Parameter(0)
    public int val1;
    @Parameterized.Parameter(1)
    public int val2;
    @Parameterized.Parameter(2)
    public int expected;

    @Parameterized.Parameters(name = "Test {index} : ({0}-{1}) = {2}")
    public static Iterable<Object[]> dataForDiff() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {-2, 2, -4},
                {10, -2, 12},
                {-7, -1, -6},
                {-8, -8, 0}
        });
    }

    @Test
    public void testDiff() {
        assertEquals(expected, calc.diff(val1, val2));
    }

    @AfterClass
    public static void destroy(){
        calc = null;
    }
}
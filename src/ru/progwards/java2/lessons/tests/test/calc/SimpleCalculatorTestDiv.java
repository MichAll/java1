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
public class SimpleCalculatorTestDiv {

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

    @Parameterized.Parameters(name = "Test {index} : ({0} / {1}) = {2}")
    public static Iterable<Object[]> dataForDiv() {
        return Arrays.asList(new Object[][]{
                {7, 7, 1},
                {-2, 2, -1},
                {1000, 25, 40},
                {7000, -10, -700},
                {1, 1, 1}
        });
    }
    @Test
    public void testDiv() {
        assertEquals(expected, calc.div(val1, val2));
    }

    @AfterClass
    public static void destroy(){
        calc = null;
    }
}

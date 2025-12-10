package com.doku.my.trainingbesenangpay01.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Daniel Joi Partogi Hutapea
 */
class CalculatorTest
{
    @Test
    void add_test()
    {
        Calculator calc = new Calculator();
        var actual = calc.add(1, 2);
        assertEquals(3, actual);
    }

    @Test
    void subtract_test()
    {
        Calculator calc = new Calculator();
        var actual = calc.subtract(1, 2);
        assertEquals(-1, actual);
    }
}

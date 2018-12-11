package ru.job4j.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Tests for class Calculator
 *
 * @author Viktor Shiyan
 * @since 11.12.2018
 */
public class CalculatorTest {
    private Calculator calculator;
    double first;
    double second;

    /**
     * Create instance Calculator
     */
    @Before
    public void setUp() {
        first = 10D;
        second = 5D;
        calculator = new Calculator();
    }

    /**
     * Test add
     */
    @Test
    public void add() {
        calculator.add(first, second);
        double result = calculator.getResult();
        double expect = 15D;
        assertThat(result, is(expect));
    }

    /**
     * Test subtraction
     */
    @Test
    public void subtraction() {
        calculator.subtraction(first, second);
        double result = calculator.getResult();
        double expect = 5D;
        assertThat(result, is(expect));
    }

    /**
     * Test multiplication
     */
    @Test
    public void multiplication() {
        calculator.multiplication(first, second);
        double result = calculator.getResult();
        double expect = 50D;
        assertThat(result, is(expect));
    }

    /**
     * Test division
     */
    @Test
    public void division() {
        calculator.division(first, second);
        double result = calculator.getResult();
        double expect = 2;
        assertThat(result, is(expect));
    }

    /**
     * Test getResult
     */
    @Test
    public void getResult() {
        calculator.add(first, second);
        double result = calculator.getResult();
        double expect = 15D;
        assertThat(result, is(expect));
    }
}
package ru.job4j.converter;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test for class Converter
 *
 * @author Viktor Shiyan
 * @since 11.12.2018
 */
public class ConverterTest {

    private Converter converter;

    @Before
    public void setUp() {
        converter = new Converter();
    }

    /**
     * Test ruble to euro
     */
    @Test
    public void rubleToEuro() {
        int expect = 100;
        int result = converter.rubleToEuro(7000);
        assertThat(result, is(expect));
    }

    /**
     * Test ruble to dollar
     */
    @Test
    public void rubleToDollar() {
        int expect = 100;
        int result = converter.rubleToDollar(6000);
        assertThat(result, is(expect));
    }

    /**
     * Test euro to ruble
     */
    @Test
    public void euroToRuble() {
        int expect = 700;
        int result = converter.euroToRuble(10);
        assertThat(result, is(expect));
    }

    /**
     * Test dollar to ruble
     */
    @Test
    public void dollarToRuble() {
        int expect = 600;
        int result = converter.dollarToRuble(10);
        assertThat(result, is(expect));
    }
}
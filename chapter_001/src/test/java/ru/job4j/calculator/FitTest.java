package ru.job4j.calculator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test for class Fit
 *
 * @author Viktor Shiyan
 * @since 11.12.2018
 */
public class FitTest {

    private Fit fit;

    @Before
    public void setUp() {
        fit = new Fit();
    }

    /**
     * Test man weight
     */
    @Test
    public void manWeight() {
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }

    /**
     * Test woman weight
     */
    @Test
    public void womanWeight() {
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
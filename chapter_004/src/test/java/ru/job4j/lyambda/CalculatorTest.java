package ru.job4j.lyambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Viktor Shiyan
 * @since 11.01.2019
 */
public class CalculatorTest {
    Calculator.Diapasoner diapasoner;

    @Before
    public void setUP() {
        diapasoner = new Calculator.Diapasoner() {
            @Override
            public List<Double> diapason(int start, int end, Function<Double, Double> func) {
                List<Double> result = new ArrayList<>();
                for (int i = start; i < end; i++) {
                    result.add(func.apply((double) i));
                }
                return result;
            }
        };
    }

    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {

        List<Double> result = diapasoner.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        List<Double> result = diapasoner.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogResults() {

        List<Double> result = diapasoner.diapason(5, 8, Math::log);
        List<Double> expected = Arrays.asList(Math.log(5), Math.log(6), Math.log(7));
        assertThat(result, is(expected));
    }

}
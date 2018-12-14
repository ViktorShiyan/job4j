package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест класса Turn
 *
 * @author Viktor Shiayn
 * @since 14.12.2018
 */
public class TurnTest {
    /**
     * Тест когда четное количество элементов
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }

    /**
     * Тест когда нечетное число элементов
     */
    @Test
    public void whenNotEvenNumberOfElements() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 7};
        int[] result = turner.back(input);
        int[] expect = new int[]{7, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }

}
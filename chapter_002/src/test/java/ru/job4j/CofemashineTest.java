package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест кофемашины
 *
 * @author ViktorShiyan
 * @since 31.12.2018
 */
public class CofemashineTest {

    /**
     * Метод тестирующий возврат сдачи
     */
    @Test
    public void changes() {
        Cofemashine cofemashine = new Cofemashine();
        int[] result = cofemashine.changes(5000, 550);
        int[] expect = new int[]{1000, 1000, 1000, 1000, 100, 100, 100, 100, 50};
        assertThat(result, is(expect));
    }
}
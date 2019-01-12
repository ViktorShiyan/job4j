package ru.job4j.deportament;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Тест проверяющий класс Codes
 *
 * @author Viktor Shiyan
 * @since 12.01.2019
 */
public class CodesTest {
    private String[] codeIn = new String[]{"K1\\SK1", "K1\\SK2",
            "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K3\\SS1", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K3"};
    private Codes codes = new Codes(codeIn);

    @Test
    public void sortAscending() {
        String[] result = codes.sortAscending();
        String[] expect = new String[]{"K1", "K1\\SK1", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K3", "K3\\SS1"};
        assertThat(result, is(expect));
    }

    @Test
    public void sortingDecreasing() {
        String[] result = codes.sortingDecreasing();
        String[] expect = new String[]{"K3", "K3\\SS1", "K2", "K2\\SK1",
                "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(result, is(expect));
    }
}
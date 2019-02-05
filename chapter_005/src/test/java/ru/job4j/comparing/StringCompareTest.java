package ru.job4j.comparing;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author ViktorShiyan
 * @since 05.02.2019
 */
public class StringCompareTest {

    @Test
    public void whenStringCompare() {
        StringCompare stringCompare = new StringCompare();
        boolean result = stringCompare.stringCompare("roza", "azzor");
        assertThat(result, is(true));
    }

    @Test
    public void whenStringCompareFalse() {
        StringCompare stringCompare = new StringCompare();
        boolean result = stringCompare.stringCompare("rozac", "azzor");
        assertThat(result, is(false));
    }
}
package ru.job4j.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Viktor Shiyan
 * @since 01.02.2019
 */
public class EventStreamTest {
    @Test
    public void evenNumber() {
        EventStream eventStream = new EventStream();
        InputStream inputStream = new ByteArrayInputStream(new byte[]{2});
        boolean result = eventStream.isNumber(inputStream);
        assertThat(result, is(true));
    }

}
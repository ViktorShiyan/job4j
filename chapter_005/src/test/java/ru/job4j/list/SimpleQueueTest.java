package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {
    @Test
    public void whenAllGood() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
        simpleQueue.push(4);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        simpleQueue.push(5);
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.poll(), is(4));
        assertThat(simpleQueue.poll(), is(5));
    }

    @Test
    public void whenNothing() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.poll();
        String result = "";
        try {
            simpleQueue.poll();
        } catch (RuntimeException ex) {
            result = ex.getMessage();
        }
        assertThat(result, is("noSuchElement"));
    }

}
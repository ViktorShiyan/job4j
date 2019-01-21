package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    @Test
    public void whenAddAndDelete() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
        assertThat(simpleStack.poll(), is(3));
        simpleStack.push(4);
        assertThat(simpleStack.poll(), is(4));
        assertThat(simpleStack.poll(), is(2));
    }

    @Test
    public void whenNothing() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        assertThat(simpleStack.poll(), is(1));
        String result = "";
        try {
            simpleStack.poll();
        } catch (RuntimeException re) {
            result = re.getMessage();
        }
        assertThat(result, is("nothing"));
    }
}
package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ContainerTest {

    private Container<Integer> container;

    @Before
    public void setUp() {
        container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);
        container.add(4);
    }

    @Test
    public void whenAddAndGet() {
        assertThat(container.get(0), is(1));
        assertThat(container.get(1), is(2));
        assertThat(container.get(2), is(3));
        assertThat(container.get(3), is(4));
    }


    @Test
    public void whenIteratorGood() {
        Iterator it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        it.next();
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenIteratorBad() {
        Iterator it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        it.next();
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        String result = "";
        try {
            it.next();
        } catch (RuntimeException re) {
            result = re.getMessage();
        }
        assertThat(result, is("error"));
    }

    @Test
    public void whenIteratorModification() {
        Iterator it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        it.next();
        container.add(5);
        String result = "";
        try {
            it.next();
        } catch (RuntimeException ex) {
            result = ex.getMessage();
        }
        assertThat(result, is("modification"));
    }
}
package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {
    private SimpleLinkedList<Integer> simpleLinkedList;

    @Before
    public void setUp() throws Exception {
        simpleLinkedList = new SimpleLinkedList<>();
        simpleLinkedList.add(1);
        simpleLinkedList.add(2);
        simpleLinkedList.add(3);
        simpleLinkedList.add(4);
    }

    @Test
    public void add() {
        assertThat(simpleLinkedList.get(0), is(4));
        assertThat(simpleLinkedList.get(1), is(3));
        assertThat(simpleLinkedList.get(2), is(2));
        assertThat(simpleLinkedList.get(3), is(1));
    }

    @Test
    public void iterator() {
        Iterator it = simpleLinkedList.iterator();
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenIteratorNothing() {
        simpleLinkedList = new SimpleLinkedList<>();
        Iterator it = simpleLinkedList.iterator();
        String result = "";
        try {
            it.next();
        } catch (RuntimeException re) {
            result = re.getMessage();
        }
        assertThat(result, is("error"));
    }

    @Test
    public void whenIteratorNoSuchElement() {
        Iterator it = simpleLinkedList.iterator();
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        String result = "";
        try {
            it.next();
        } catch (RuntimeException re) {
            result = re.getMessage();
        }
        assertThat(result, is("error"));
    }
}
package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAllGood() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("uniq");
        simpleSet.add("uniq");
        simpleSet.add("uniq");
        simpleSet.add("set");
        Iterator it = simpleSet.iterator();
        assertThat(it.next(), is("uniq"));
        assertThat(it.next(), is("set"));
    }
}
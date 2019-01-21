package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class NodeTest {
    private Node<Integer> first;
    private Node<Integer> two;
    private Node<Integer> third;
    private Node<Integer> four;

    @Before
    public void setUp() {
        first = new Node<>(1);
        two = new Node<>(2);
        third = new Node<>(3);
        four = new Node<>(4);
    }

    @Test
    public void whenCycle() {

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
        assertThat(Node.hasCycle(first), is(true));
    }

    @Test
    public void whenNotCycle() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = null;
        assertThat(Node.hasCycle(first), is(false));
    }

    @Test
    public void whenCycleInCentre() {
        first.next = two;
        two.next = third;
        third.next = two;
        four.next = null;
        assertThat(Node.hasCycle(first), is(true));
    }
}
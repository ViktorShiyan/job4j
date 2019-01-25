package ru.job4j.tree;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
    @Test
    public void ifTreeBinaryThenIsBinaryReturnTrue() {
        Tree<Integer> testTree = new Tree<>(1);
        testTree.add(1, 2);
        testTree.add(1, 3);
        testTree.add(2, 4);
        testTree.add(3, 5);
        testTree.add(3, 6);
        assertThat(testTree.isBinary(), is(true));
    }
    @Test
    public void ifTreeNotBinaryThenIsBinaryReturnFalse() {
        Tree<Integer> testTree = new Tree<>(1);
        testTree.add(1, 2);
        testTree.add(1, 3);
        testTree.add(2, 4);
        testTree.add(2, 5);
        testTree.add(3, 6);
        testTree.add(3, 7);
        testTree.add(3, 8);
        assertThat(testTree.isBinary(), is(false));
    }
}
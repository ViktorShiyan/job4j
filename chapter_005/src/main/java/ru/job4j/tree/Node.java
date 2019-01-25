package ru.job4j.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывающий ноду дерева
 *
 * @author Viktor Shiyan
 * @since 25.01.2019
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    public Node(final E value) {
        this.value = value;
    }

    /**
     * Метод добавляющий дочерний элемент в ноду
     *
     * @param child добавленный элемент
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * Метод возвращающий список дочерних элементов
     *
     * @return
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * Метод для получения значения
     *
     * @return значение
     */
    public E getValue() {
        return this.value;
    }

    /**
     * @param that элемент
     * @return равны ли элементы
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }
}

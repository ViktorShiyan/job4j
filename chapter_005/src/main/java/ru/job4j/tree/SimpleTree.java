package ru.job4j.tree;

import java.util.Optional;

/**
 * Интерфейс для реализации дерева
 *
 * @param <E> тип хранимых элементов
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return удалось ли добавить
     */
    boolean add(E parent, E child);

    /**
     * Производит поиск узла по заданному значению.
     *
     * @param value заданное значение.
     * @return искомый узел.
     */
    Optional<Node<E>> findBy(E value);
}
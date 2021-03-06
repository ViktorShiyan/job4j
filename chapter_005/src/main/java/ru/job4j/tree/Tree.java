package ru.job4j.tree;

import java.util.*;

/**
 * Структура данных - простое дерево.
 *
 * @param <E> Параметризованный тип данных, хранящихся в коллекции.
 * @author Viktor Shiyan
 * @since 25.01.2019
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Корень дерева.
     */
    private Node<E> root;

    /**
     * Счетчик изменений коллекции, которые могут повлиять на итератор.
     */
    private int modCount;

    /**
     * Текущий, проверяемый методом isBinary, узел.
     */
    private Node<E> checkingNode;

    /**
     * Конструктор, инициализирует корень дерева.
     *
     * @param root корень
     */
    public Tree(E root) {
        Node<E> newRoot = new Node<>(root);
        this.root = newRoot;
        this.checkingNode = newRoot;
    }

    /**
     * Добавляет элемент в дерево.
     *
     * @param parent корень к которому добавляем.
     * @param child  добавляемый элемент.
     * @return true - если добавление прошло успешно.
     * false - если не удалось добавить элемент.
     */
    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> foundParent = findBy(parent);
        boolean result = false;
        if (foundParent.isPresent() && foundParent.get().leaves().stream().noneMatch(x -> x.getValue().equals(child))) {
            foundParent.get().add(new Node<>(child));
            modCount++;
            result = true;
        }
        return result;
    }

    /**
     * Проверяет, является ли дерево бинарным.
     *
     * @return true - если дерево бинарное.
     * false - если дерево не бинарное.
     */
    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            final List<Node<E>> leaves = node.leaves();
            if (leaves.size() > 2) {
                result = false;
                break;
            }
            queue.addAll(leaves);
        }
        return result;
    }

    /**
     * Производит поиск заданного элемента.
     *
     * @param value заданный элемент.
     * @return узел, заданного элемента.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (element.eqValue(value)) {
                result = Optional.of(element);
                break;
            }
            for (Node<E> child : element.leaves()) {
                data.offer(child);
            }
        }
        return result;
    }

    /**
     * @return Итератор, для обхода дерева.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Queue<Node<E>> nodesQueue = new LinkedList<>(Collections.singleton(root));
            private int expectedModCount = modCount;


            /**
             * Проверяет наличие следующих элементов.
             * @return true - если элементы есть.
             *         false - если элементов больше нет.
             */
            @Override
            public boolean hasNext() {
                return !nodesQueue.isEmpty();
            }

            /**
             * Возвращает значение узла дерева по очереди.
             * @return значение узла.
             */
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> tmp = this.nodesQueue.poll();
                tmp.leaves().forEach(x -> nodesQueue.offer(x));
                return tmp.getValue();
            }
        };
    }
}
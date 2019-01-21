package ru.job4j.list;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс контейнер на базе связанного списка
 *
 * @param <E> тип хранимых элементов
 * @author Viktor Shiayn
 * @since 19.01.2019
 */
public class SimpleLinkedList<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private int modeCheck = 0;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modeCheck++;
    }


    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        if (index < this.size && index >= 0) {
            Node<E> res = this.first;
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
            return res.date;
        } else {
            throw new RuntimeException("index_error");
        }
    }

    /**
     * Метод удаления первого элемент в списке.
     */
    public E delete() {
        if (this.size == 0) {
            throw new RuntimeException("nothing");
        }
        Node<E> result = this.first;
        this.first = first.next;
        size--;
        return result.date;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Node<E> currentNode = first;
            private int itIndex = 0;
            private int expectMod = modeCheck;

            @Override
            public boolean hasNext() {
                return this.itIndex < size;
            }

            @Override
            public E next() {
                E result;
                if (this.expectMod != modeCheck) {
                    throw new ConcurrentModificationException("modification");
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("error");
                }
                result = this.currentNode.date;
                this.currentNode = this.currentNode.next;
                this.itIndex++;
                return result;
            }
        };
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}

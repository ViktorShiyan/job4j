package ru.job4j.list;

import java.util.Iterator;

/**
 * Реализация простого множества
 *
 * @param <E> тип хранимых элементов\
 * @author Viktor Shiayn
 * @since 21.01.2019
 */
public class SimpleSet<E> implements Iterable<E> {
    private Container<E> container = new Container<>();

    /**
     * Метод проверяет уникальность элемента и добавляет его если он уникален
     *
     * @param e элемент для добавления
     */
    public void add(E e) {
        if (this.contain(e)) {
            container.add(e);
        }
    }

    /**
     * @return итератор множества
     */
    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }

    /**
     * Метод проверки на уникальность
     *
     * @param element входной элемент
     * @return true если элимент уникален
     */
    private boolean contain(E element) {
        boolean uniq = true;
        for (E o : container) {
            if (o.equals(element)) {
                uniq = false;
                break;
            }
        }
        return uniq;
    }
}

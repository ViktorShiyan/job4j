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
        boolean uniq = true;
        for (E o : container) {
            if (o.equals(e)) {
                uniq = false;
                break;
            }
        }
        if (uniq) {
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
}

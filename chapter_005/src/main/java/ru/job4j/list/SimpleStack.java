package ru.job4j.list;

/**
 * Реализация простого стэка
 * на SimpleLinkedList
 *
 * @param <T> тип входящего элемента
 * @author Viktor Shiyan
 * @since 21.01.2019
 */
public class SimpleStack<T> {

    private SimpleLinkedList<T> tSimpleLinkedList = new SimpleLinkedList<>();

    /**
     * Метод удаляет первое значение
     *
     * @return удаляемое значение
     */
    public T poll() {
        return tSimpleLinkedList.delete();
    }

    /**
     * Метод добавляет значение
     *
     * @param value
     */
    public void push(T value) {
        this.tSimpleLinkedList.add(value);
    }

    public boolean isEmpty() {
        return this.tSimpleLinkedList.getSize() == 0;
    }
}
package ru.job4j.tracker;

/**
 * Класс ввода пользовательских значений через массив
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове указатель увеличивается на 1.
     */
    private int position;

    /**
     * Конструктор
     *
     * @param value массив команд
     */
    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Последовательная выдача запросов
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }
}
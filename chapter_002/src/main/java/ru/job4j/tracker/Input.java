package ru.job4j.tracker;

/**
 * Интерфейс для ввода данных
 *
 * @author Viktor Shiyan
 * @since 24.12.18
 */
public interface Input {
    /**
     * Метод возращающий строку
     *
     * @param question вопрос
     * @return ключ
     */
    String ask(String question);

}
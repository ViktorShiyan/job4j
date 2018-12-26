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

    /**
     * Метод возращающий число из диапозона
     *
     * @param question вопрос
     * @param range    диапозон
     * @return ключ
     */
    int ask(String question, int[] range);

}
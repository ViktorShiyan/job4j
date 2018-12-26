package ru.job4j.tracker;

/**
 * Интерфейс пользовательских действий
 *
 * @author Viktor Shiyan
 * @since 26.12.18
 */
public interface UserAction {
    /**
     * Метод возвращающий ключ выбора действия
     *
     * @return ключ
     */
    int key();

    /**
     * Метод исполняющий действие
     *
     * @param input   клаас для ввода данных
     * @param tracker база трекера
     */
    void execute(Input input, Tracker tracker);

    /**
     * @return информацию о действии
     */
    String info();
}

package ru.job4j.tracker;


/**
 * Класс пользовательского интерфейса
 *
 * @author ViktorShiyan
 * @since 23.12.2018
 */
public class StartUI {
    /**
     * Диапозон значений
     */
    private int[] range = new int[]{0, 1, 2, 3, 4, 5};
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     *
     * @param args аргкменты для запуска.
     */
    public static void main(String[] args) {
        new StartUI(new ValidInput(), new Tracker()).init();
    }
}
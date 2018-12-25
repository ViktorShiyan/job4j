package ru.job4j.tracker;

/**
 * Класс пользовательского интерфейса
 *
 * @author ViktorShiyan
 * @since 23.12.2018
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOW_ALL = "1";
    /**
     * Константа меню для правки заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELITE = "3";
    /**
     * Константа меню для поиска по ID.
     */
    private static final String FIND_BY_ID = "4";
    /**
     * Константа меню для поиска имени.
     */
    private static final String FIND_BY_NAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW_ALL.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELITE.equals(answer)) {
                this.delite();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findByID();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findBYyName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            } else {
                System.out.println("Неизвестная команда");
            }
        }
    }

    /**
     * Метод для поиска заявок по имени
     */
    private void findBYyName() {
        String name = input.ask("Введите название заявки для поиска");
        Item[] findedItems = tracker.findByName(name);
        if (findedItems.length != 0) {
            for (Item item : findedItems) {
                System.out.println("Заявка: " + item.getName() + "\nОписание: " + item.getDesc() + "\n");
            }
        } else {
            System.out.println("Нет заявок с таким названием");
        }
    }

    /**
     * Метод для поиска заявки по ID
     */
    private void findByID() {
        String id = input.ask("Введите ID для поиска заявки");
        Item findedItem = tracker.findById(id);
        if (findedItem != null) {
            System.out.println("Заявка: " + findedItem.getName() + "\nОписание: " + findedItem.getDesc() + "\n");
        } else {
            System.out.println("Заявка с таким ID не найдена");
        }
    }

    /**
     * Метод для удаления заявки
     */
    private void delite() {
        String id = input.ask("Введите Id удаляемой заявки");
        if (tracker.delete(id)) {
            System.out.println("Заявка c ID " + id + " удалена");
        } else {
            System.out.println("Нет заявки с таким ID");
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует показ всех заявок.
     */
    private void showAll() {
        Item[] items = this.tracker.findAll();
        if (items.length != 0) {
            for (Item item : items) {
                System.out.println("------------" + item.getName() + " c ID " + item.getId() + "-----------");
            }
        } else {
            System.out.println("------------Заявок нет!-------------");
        }

    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void edit() {
        String id = this.input.ask("Введите id нужной заявки");
        String name = this.input.ask("Введите название заявки");
        String descr = this.input.ask("Введите описание заявки");
        Item newItem = new Item(name, descr);
        if (!this.tracker.replace(id, newItem)) {
            System.out.println("Заявки с таким ID не найденно");
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");

    }

    /**
     * Запускт программы.
     *
     * @param args аргкменты для запуска.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
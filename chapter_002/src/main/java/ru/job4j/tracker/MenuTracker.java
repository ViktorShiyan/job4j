package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс отвечающий за вывод меню и выполнение действий
 *
 * @author Viktor Shiayn
 * @since 26.12.2018
 */
public class MenuTracker {

    private static final int ADD = 0;
    private static final int SHOW = 1;
    private static final int EDIT = 2;
    private static final int DELETE = 3;
    private static final int FINDBYID = 4;
    private static final int FINDBYNAME = 5;
    private static final int EXIT = 6;

    private Tracker tracker;
    private Input input;
    private List<UserAction> actions = new ArrayList<>();

    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    /**
     * Метод заполняет массив
     */
    public void fillActions() {
        this.actions.add(new AddItem(ADD, "Add new Item."));
        this.actions.add(new FindAll(SHOW, "Show all items"));
        this.actions.add(new EditItem(EDIT, "Edit item"));
        this.actions.add(new DeleteItem(DELETE, "Delete item"));
        this.actions.add(new MenuTracker.FindId(FINDBYID, "Find item by Id"));
        this.actions.add(new FindName(FINDBYNAME, "Find items by name"));
        this.actions.add(new ExitProgram(EXIT, "Exit"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутрений Класс реализуюший интерфейс UserAction и добавляющий заявку
     */

    private class AddItem extends BaseAction {
        /**
         * Конструктор принимает ключ и название
         *
         * @param key  ключ
         * @param name название
         */
        AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    /**
     * Внутрений Класс реализуюший интерфейс UserAction и удаляющий заявку
     */
    private class DeleteItem extends BaseAction {
        /**
         * Конструктор принимает ключ и название
         *
         * @param key  ключ
         * @param name название
         */
        DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите Id удаляемой заявки");
            if (tracker.delete(id)) {
                System.out.println("Заявка c ID " + id + " удалена");
            } else {
                System.out.println("Нет заявки с таким ID");
            }
        }
    }

    /**
     * Внутрений  Класс выполняющий вывод всех не нулевых заявок
     */
    private class FindAll extends BaseAction {
        /**
         * @param key  ключ
         * @param name название
         */
        FindAll(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items.length != 0) {
                for (Item item : items) {
                    System.out.println("------------" + item.getName() + " c ID " + item.getId() + "-----------");
                }
            } else {
                System.out.println("------------Заявок нет!-------------");
            }
        }
    }

    /**
     * Внутрений Класс выполняющий вывод заявки по id
     */
    private class FindId extends BaseAction {

        FindId(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите ID для поиска заявки");
            Item findedItem = tracker.findById(id);
            if (findedItem != null) {
                System.out.println(findedItem.toString());
            } else {
                System.out.println("Заявка с таким ID не найдена");
            }
        }
    }

    /**
     * Внутренний класс выполняющий вывод по названию заявки
     */
    private class FindName extends BaseAction {

        FindName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите название заявки для поиска");
            Item[] findedItems = tracker.findByName(name);
            if (findedItems.length != 0) {
                for (Item item : findedItems) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Нет заявок с таким названием");
            }
        }
    }

    /**
     * Внутренний класс выполняющий редактирование по названию заявки
     */
    private class EditItem extends BaseAction {

        EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id нужной заявки");
            String name = input.ask("Введите название заявки");
            String descr = input.ask("Введите описание заявки");
            Item newItem = new Item(name, descr);
            if (!tracker.replace(id, newItem)) {
                System.out.println("Заявки с таким ID не найденно");
            }
        }
    }

    /**
     * Класс отвечающий за выход из программы.
     */
    private class ExitProgram extends BaseAction {

        ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}


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

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";

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
        this.actions.add(new AddItem());
        this.actions.add(new MenuTracker.FindAll());
        this.actions.add(new EditItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new MenuTracker.FindId());
        this.actions.add(new FindName());
        this.actions.add(new ExitProgram());
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

    private class AddItem implements UserAction {
        @Override
        public int key() {
            return Integer.valueOf(ADD);
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

        @Override
        public String info() {
            return this.key() + " Add new Item.";
        }
    }

    /**
     * Внутрений Класс реализуюший интерфейс UserAction и удаляющий заявку
     */
    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return Integer.valueOf(DELETE);
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

        @Override
        public String info() {
            return this.key() + "  Delete item";
        }

    }

    /**
     * Внутрений  Класс выполняющий вывод всех не нулевых заявок
     */
    private class FindAll implements UserAction {


        @Override
        public int key() {
            return Integer.valueOf(SHOW);
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

        @Override
        public String info() {
            return this.key() + " Show all items";
        }
    }

    /**
     * Внутрений Класс выполняющий вывод заявки по id
     */
    private class FindId implements UserAction {

        @Override
        public int key() {
            return Integer.valueOf(FINDBYID);
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

        @Override
        public String info() {
            return this.key() + " Find item by Id";
        }

    }

    /**
     * Внутренний класс выполняющий вывод по названию заявки
     */
    private class FindName implements UserAction {

        @Override
        public int key() {
            return Integer.valueOf(FINDBYNAME);
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

        @Override
        public String info() {
            return this.key() + " Find items by name";
        }

    }

    /**
     * Внутренний класс выполняющий редактирование по названию заявки
     */
    private class EditItem implements UserAction {

        @Override
        public int key() {
            return Integer.valueOf(EDIT);
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

        @Override
        public String info() {
            return this.key() + " Edit item";
        }
    }

    /**
     * Класс отвечающий за выход из программы.
     */
    private class ExitProgram implements UserAction {

        @Override
        public int key() {
            return Integer.parseInt(EXIT);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return key() + ". Exit";
        }
    }
}


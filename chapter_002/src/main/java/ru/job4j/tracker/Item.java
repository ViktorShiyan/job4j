package ru.job4j.tracker;

/**
 * Класс реализующий заявку
 *
 * @author Viktor Shiayn
 * @since 21.12.2018
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.created = System.currentTimeMillis();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    /**
     * Метод присваевающий значение
     *
     * @param id значение id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Заявка: " + this.getName() + "\nОписание:" + this.getDesc() + "\n";
    }
}

package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Класс трекер хранящий даные о заявках в sql
 *
 * @author viktorshiyan
 * @since 14.03.2019
 */
public class TrackerSQL implements ITracker, AutoCloseable {

    /**
     * Соединение с базой
     */
    private Connection connection;

    private static final Random RN = new Random();

    /**
     * конструктор инициализирующий таблицу в базе данных
     */
    public TrackerSQL() {
        init();
        try {
            Statement stat = this.connection.createStatement();
            stat.executeUpdate("CREATE TABLE IF NOT EXISTS item(id VARCHAR(30) PRIMARY KEY, name VARCHAR(30), description VARCHAR(30),created BIGINT);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод для добавления заявки в базу данных
     *
     * @param item заявка
     * @return заявку
     */
    @Override
    public Item add(Item item) {
        try (PreparedStatement pStat = this.connection
                .prepareStatement("INSERT INTO item(id, name, description, created) values (?,?,?,?);")) {
            pStat.setString(1, this.generateID());
            pStat.setString(2, item.getName());
            pStat.setString(3, item.getDesc());
            pStat.setLong(4, item.getCreated());
            pStat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * метод возвращающий все заявки
     *
     * @return список всех заявок
     */
    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (Statement stat = this.connection.createStatement()) {
            ResultSet rs = stat.executeQuery("SELECT * FROM item");
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getString("description"));
                item.setId(rs.getString("id"));
                item.setCreated(rs.getLong("created"));
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * метод удаляющий запись из базы данных
     *
     * @param id id заявки
     * @return true если удалилась
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        try (PreparedStatement pStat = this.connection
                .prepareStatement("DELETE FROM item WHERE id = ?")) {
            pStat.setString(1, id);
            pStat.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * метод для изменения заявки
     *
     * @param id   id заявки
     * @param item новая заявка
     * @return true если успешно
     */
    @Override
    public boolean replace(String id, Item item) {
        boolean result = false;
        try (PreparedStatement pStat = this.connection
                .prepareStatement("UPDATE item SET name = ?, description = ? WHERE id = ?")) {
            pStat.setString(1, item.getName());
            pStat.setString(2, item.getDesc());
            pStat.setString(3, id);
            pStat.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * метод для поиска заявки по id
     *
     * @param id id искомой заявки
     * @return искомую заявку
     */
    @Override
    public Item findById(String id) {
        Item result = null;
        try (PreparedStatement pStat = this.connection
                .prepareStatement("SELECT * FROM item WHERE id = ?")) {
            pStat.setString(1, id);
            ResultSet rs = pStat.executeQuery();
            while (rs.next()) {
                result = new Item(rs.getString("name"),
                        rs.getString("description"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Метод для поиска заявки по имени
     *
     * @param key ключ поиска
     * @return список подходящих заявок
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement pStat = this.connection
                .prepareStatement("SELECT * FROM item WHERE name = ?")) {
            pStat.setString(1, key);
            ResultSet rs = pStat.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"), rs.getString("description"));
                item.setCreated(rs.getLong("created"));
                item.setId(rs.getString("id"));
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Инициирование подключение к базе данных
     *
     * @return false если подключиться не удалось
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    /**
     * Метод удаляющий таблицу в базе данных
     */
    public void dropTable() {
        try (PreparedStatement pStat = this.connection
                .prepareStatement("DROP TABLE item")) {
            pStat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод закрывающий  соединение
     *
     * @throws Exception при неудачном закрытии
     */
    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    /**
     * Метод возвращающий текущее соединение
     *
     * @return текущее соединение
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Метод генерирующий Id
     * в милисикундах прлюс случайное число
     *
     * @return id
     */
    private String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}

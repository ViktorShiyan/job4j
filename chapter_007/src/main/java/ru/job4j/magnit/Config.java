package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Properties;

/**
 * класс для конфигурации приложения
 *
 * @author viktorshiyan
 * @since 15.03.2019
 */
public class Config {
    private final Properties values = new Properties();

    public Config() {
        init();
    }

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app2.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String getUrl() {
        return this.values.getProperty("url");
    }

}
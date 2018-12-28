package ru.job4j.tracker.singletone;

import ru.job4j.tracker.TrackerAbstract;

/**
 * Static final field. Eager loading.
 * Singleton получается за счет создание константы
 * и сокрытия конструктора.
 */
public class TrackerFinalFieldEager extends TrackerAbstract {
    private static final TrackerFinalFieldEager INSTANCE = new TrackerFinalFieldEager();

    private TrackerFinalFieldEager() {
    }

    public static TrackerFinalFieldEager getInstance() {
        return INSTANCE;
    }
}

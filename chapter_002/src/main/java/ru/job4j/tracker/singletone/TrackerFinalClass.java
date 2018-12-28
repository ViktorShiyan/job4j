package ru.job4j.tracker.singletone;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.TrackerAbstract;

/**
 * Private static final class. Lazy loading.
 * Singleton за счет поля скрытого во скрытом внутреннем классе.
 */
public class TrackerFinalClass extends TrackerAbstract {
    private TrackerFinalClass() {
    }

    public static TrackerFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerFinalClass INSTANCE = new TrackerFinalClass();
    }
}

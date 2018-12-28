package ru.job4j.tracker.singletone;

import ru.job4j.tracker.TrackerAbstract;

/**
 * Static field. Lazy loading.
 * Синглтон за счет скрытого статического поля.
 * Экземпляр возращается всегда один,
 * создается после обращения
 */
public class TrackerStaticFieldLazy extends TrackerAbstract {

    private static TrackerStaticFieldLazy instance;

    private TrackerStaticFieldLazy() {
    }

    public static TrackerStaticFieldLazy getInstance() {
        if (instance == null) {
            instance = new TrackerStaticFieldLazy();
        }
        return instance;
    }
}

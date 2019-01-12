package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс показывающий работу Stream API
 *
 * @author Viktor Shiayn
 * @since 12.01.2019
 */
public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" + "name='" + name + '\'' + ", spent=" + spent + '}';
        }

        public String getName() {
            return name;
        }
    }
}

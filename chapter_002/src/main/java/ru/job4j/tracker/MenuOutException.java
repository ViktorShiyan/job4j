package ru.job4j.tracker;

/**
 * Класс описывающий ошибку при выходе из диапозона
 *
 * @author Viktor Shiyan
 * @since 26.12.18
 */
class MenuOutExeption extends RuntimeException {
    MenuOutExeption(String msg) {
        super(msg);
    }
}

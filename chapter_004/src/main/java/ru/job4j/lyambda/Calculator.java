package ru.job4j.lyambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Класс описывает салькулятор на лямбде
 *
 * @author Viktor Shiyan
 * @since 11.01.2019
 */
public class Calculator {

    /**
     * Метод вычисляет таблицу умножения
     *
     * @param start  начало интервала
     * @param finish конец интервала
     * @param value  значение
     * @param op     интерфейс для операции
     * @param media  интерфейс для вывода
     */
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }
}

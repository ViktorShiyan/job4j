package ru.job4j.calculator;

/**
 * Класс для простых арифметических действий с  двумя числами
 *
 * @author Viktor Shiyan
 * @since 11.12.2018
 */
public class Calculator {

    private double result;

    /**
     * Метод для сложения двух чисел double
     * результат сложения записывается в поле result
     *
     * @param first  - первое число
     * @param second - второе число
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Метод для вычитания одного числа double из другого
     * результат записывается в поле result
     *
     * @param first  - первое число
     * @param second - второе число
     */
    public void subtraction(double first, double second) {
        this.result = first - second;
    }

    /**
     * Метод для умножения двух чисел double
     * результат записывается в поле result
     *
     * @param first  - первое число
     * @param second - второе число
     */
    public void multiplication(double first, double second) {
        this.result = first * second;
    }

    /**
     * Метод для деления одного числа на другое
     * результат записывается в поле result
     *
     * @param first  - первое число
     * @param second - второе число
     */
    public void division(double first, double second) {
        this.result = first / second;
    }

    /**
     * Метод возвращающий поле result
     *
     * @return - возвращает значение поля result
     */
    public double getResult() {
        return this.result;
    }

}

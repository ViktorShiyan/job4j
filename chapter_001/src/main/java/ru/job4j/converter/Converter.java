package ru.job4j.converter;

/**
 * Currency converter for dollar and euro
 *
 * @author Viktor Shiyan
 * @since 11.12.2018
 */
public class Converter {
    private int euro = 70;
    private int dollar = 60;

    /**
     * Convert ruble to euro
     *
     * @param value ruble
     * @return euro
     */
    public int rubleToEuro(int value) {
        return value / euro;
    }

    /**
     * Convert ruble to dollar
     *
     * @param value ruble
     * @return dollar
     */
    public int rubleToDollar(int value) {
        return value / dollar;
    }

    /**
     * Convert euro to ruble
     *
     * @param value euro
     * @return ruble
     */
    public int euroToRuble(int value) {
        return value * euro;
    }

    /**
     * Convert dollar to ruble
     *
     * @param value dollar
     * @return ruble
     */
    public int dollarToRuble(int value) {
        return value * dollar;
    }
}

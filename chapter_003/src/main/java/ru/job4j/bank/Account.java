package ru.job4j.bank;

/**
 * Класс описывающий счёт
 *
 * @author Viktor Shiyan
 * @since 09.01.2019
 */
public class Account {
    private double value;
    private String requisits;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisits() {
        return requisits;
    }

    public void setRequisits(String requisits) {
        this.requisits = requisits;
    }

    public Account(double value, String requisits) {
        this.value = value;
        this.requisits = requisits;
    }

    @Override
    public String toString() {
        return this.requisits;
    }
}

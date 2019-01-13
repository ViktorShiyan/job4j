package ru.job4j.student;

import java.util.Comparator;

/**
 * Класс описывающий студента
 *
 * @author Viktor Shiyan
 * @since 13.01.2019
 */
public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getScope() - o1.getScope();
    }
}

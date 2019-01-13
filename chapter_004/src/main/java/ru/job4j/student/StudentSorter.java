package ru.job4j.student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для сортировки
 *
 * @author Viktor Shiyan
 * @since 13.01.2019
 */
public class StudentSorter {
    /**
     * Метод сортировки студентов по оценке
     *
     * @param students список студентов
     * @param bound    минимальная оценка
     * @return список студентов
     */
    public List<Student> levelOf(List<Student> students, int bound) {
        //Коментарий добавлен только для того что бы спросить
        //какой из вариантов лучше.
        //Тесты проходят оба варианта
        //return students.stream().filter(student -> student.getScope() >= bound).collect(Collectors.toList());

        return students.stream()
                .sorted((o1, o2) -> o1.compare(o1, o2))
                .takeWhile(student -> student.getScope() >= bound)
                .collect(Collectors.toList());
    }
}

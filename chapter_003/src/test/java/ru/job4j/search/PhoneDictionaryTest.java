package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        List<Person> persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySoname() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        List<Person> persons = phones.find("Shiayn");
        assertThat(persons.iterator().next().getName(), is("Viktor"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        List<Person> persons = phones.find("Omsk");
        assertThat(persons.iterator().next().getSurname(), is("Shiayn"));
    }

    @Test
    public void whenFindByNumber() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        List<Person> persons = phones.find("5348");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}

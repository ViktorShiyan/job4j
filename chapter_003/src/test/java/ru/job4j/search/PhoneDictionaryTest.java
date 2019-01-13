package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindBySoname() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        var persons = phones.find("Shiayn");
        assertThat(persons.iterator().next().getName(), is("Viktor"));
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        var persons = phones.find("Omsk");
        assertThat(persons.iterator().next().getSurname(), is("Shiayn"));
    }

    @Test
    public void whenFindByNumber() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Viktor", "Shiayn", "6666666", "Omsk"));
        var persons = phones.find("5348");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}

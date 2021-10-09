package ru.job4j.search;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key)) {
                result.add(person);
                break;
            }
            if (person.getSurname().contains(key)) {
                result.add(person);
                break;
            }
            if (person.getPhone().contains(key)) {
                result.add(person);
                break;
            }
            if (person.getAddress().contains(key)) {
                result.add(person);
                break;
            }
        }
        return result;
    }
}

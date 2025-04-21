package org.lexicon.dao.impl;

import org.lexicon.dao.interfaces.PersonDAO;
import org.lexicon.model.AppUser;
import org.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private final List<Person> personList = new ArrayList<>();


    @Override
    public Person persist(Person person) {
        personList.add(person);
        return person;
    }

    @Override
    public Person findById(int id) {
        for (Person p : personList){
            if (p.getId() == id) return p;
            }
        return null;
        }

    @Override
    public Person findByEmail(String email) {
        for (Person p : personList){
            if (p.getEmail().equals(email)) return p;
        } return null;
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == id) {
                Person removed = personList.remove(i);
                System.out.println("Removed: " + removed);
                return;
            }
        }
        System.out.println("No person found with id: " + id);
    }

    @Override
    public String toString() {
        return "PersonDAOImpl{" +
                "personList=" + personList +
                '}';
    }
}

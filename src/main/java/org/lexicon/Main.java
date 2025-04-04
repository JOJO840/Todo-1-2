package org.lexicon;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //testing branch 1

        Person person1 = new Person("josipo", "fda", "dad@");

        System.out.println(person1);
        TodoItem todoItem = new TodoItem("houseworking",  LocalDate.of(2025,5,2)
                ,"working at house", person1);
        System.out.println(todoItem.getSummary());
        System.out.println(todoItem.isOverdue());
        System.out.println(todoItem.isDone());

    }
}
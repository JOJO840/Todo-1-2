package org.lexicon;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //testing branch 1

        Person person1 = new Person("Dragan", "Colic", "drd@.gmailse");
        Person person2 = new Person("Johan", "Adamsson", "adam@gmail.se");
        Person person3 = new Person("Per", "Svensson", "Per@gmail.se");


        TodoItem todoItem1 = new TodoItem("fix car",  LocalDate.of(2025,5,2)
                ,"must fix the car", person1);
        TodoItem todoItem2 = new TodoItem("get money", LocalDate.of(2026,4,2), "Must get money", person2);
        TodoItem todoItem3 = new TodoItem("Music lesson", LocalDate.of(2026,4,2), "Music lesson to  be made", person3);

        TodoItemTask task1 = new TodoItemTask(todoItem1,person1);
        TodoItemTask task2 = new TodoItemTask(todoItem2,person2);
        TodoItemTask task3 = new TodoItemTask(todoItem3,person3);
        System.out.println(task1.getSummary());
        System.out.println("\n" + task2.getSummary());
        System.out.println("\n" + task3.getSummary());




    }
}
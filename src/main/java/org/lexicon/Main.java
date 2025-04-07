package org.lexicon;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Dragan", "Colic", "drd@example.com");
        Person person2 = new Person("Jovan", "Colic", "janne1@example.com");
        Person person3 = new Person("Josip", "Jovanovic", "Sven@example.com");

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println("testing the new equals method: " + person1.equals(person2));
        System.out.println("hashcode: " + person1.hashCode());// should print false

        TodoItem todoItem1 = new TodoItem("Buy groceries", LocalDate.of(2025, 12, 31), "Buy milk, eggs, and bread", person1);
        TodoItem todoItem2 = new TodoItem("Learn a new Language", LocalDate.of(2025, 12, 31), "Learn English", person2);

        System.out.println("tessting todoitems: " + todoItem1 + "\n" +todoItem2);
        System.out.println("testing the new equals method: " + todoItem1.equals(todoItem2));
        System.out.println("todoItem1 hashcode: " + todoItem1.hashCode());// should print false

        AppUser user1 = new AppUser("AudiRS6", "password123", person1, AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("janne_bmw", "password123", person2, AppRole.ROLE_APP_USER);
        AppUser user3 = new AppUser("erik_toyota424", "password123", person3, AppRole.ROLE_APP_USER);

        System.out.println("user1 hashCode: " + user1.hashCode());
        System.out.println("user2 hashCode: " + user2.hashCode());
        System.out.println("user3 hashCode: " + user3.hashCode());

        user2.setRole(AppRole.ROLE_APP_ADMIN); //gets Admin role.
        System.out.println("user2 role: " + user2.getRole().getRoleName());
        System.out.println("user2 summary: " + user2.getSummary());


        System.out.println("user1 equals user2: " + user1.equals(user2)); // should print true
        System.out.println("user1 equals user3: " + user1.equals(user3)); // should print false
        System.out.println(user1); //to string method.
    }
}
package org.lexicon;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private static int counter = 0;

    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        this.id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()){
            throw  new IllegalArgumentException("First name cannot be empty!");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()){
            throw  new IllegalArgumentException("First name cannot be empty!");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email== null || !email.contains("@")){
            throw  new IllegalArgumentException("requires @");
        }
        this.email = email;
    }

    public String getSummary() {
        return "ID: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email;
    }

}

package org.lexicon;

import java.util.Objects;

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
            throw  new IllegalArgumentException("Last name cannot be empty!");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email== null || !email.contains("@")){
            throw  new IllegalArgumentException("requires @");
        }
        this.email = email;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        return id == ((Person) o).id &&
                Objects.equals(firstName, ((Person) o).firstName) &&
                Objects.equals(lastName, ((Person) o).lastName) &&
                Objects.equals(email, ((Person) o).email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

}

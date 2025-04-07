package org.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonCreation() {
        Person person = new Person("John", "Doe", "john.doe@example.com");
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("john.doe@example.com", person.getEmail());
    }

    @Test
    void testInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("", "Doe", "john.doe@example.com");
        });
        assertEquals("First name cannot be empty!", exception.getMessage());
    }

    @Test
    void testInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("John", "", "john.doe@example.com");
        });
        assertEquals("Last name cannot be empty!", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person("John", "Doe", "johndoe.com");
        });
        assertEquals("requires @", exception.getMessage());
    }
}
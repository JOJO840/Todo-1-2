package org.lexicon;

import org.junit.jupiter.api.Test;
import org.lexicon.model.AppRole;
import org.lexicon.model.AppUser;
import org.lexicon.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPersonCreation() {
        AppUser user = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        Person person = new Person("John", "Doe", "john.doe@example.com", user);
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("john.doe@example.com", person.getEmail());
        assertEquals(user, person.getCredentials());
    }

    @Test
    void testToStringExcludesCredentials() {
        AppUser user = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        Person person = new Person("John", "Doe", "john.doe@example.com", user);
        assertFalse(person.toString().contains("testUser"));
    }

    @Test
    void testEqualsAndHashCode() {
        AppUser user1 = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        Person person1 = new Person("John", "Doe", "john.doe@example.com", user1);
        Person person2 = new Person("John", "Doe", "john.doe@example.com", user1);
        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testInvalidEmailThrowsException() {
        AppUser user = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        assertThrows(IllegalArgumentException.class, () -> new Person("John", "Doe", "invalidEmail", user));
    }
}
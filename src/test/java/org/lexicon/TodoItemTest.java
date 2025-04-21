package org.lexicon;

import org.junit.jupiter.api.Test;
import org.lexicon.model.AppRole;
import org.lexicon.model.AppUser;
import org.lexicon.model.Person;
import org.lexicon.model.TodoItem;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    @Test
    void testConstructorAndGetters() {
        AppUser user = new AppUser("testUser", "password123", AppRole.ROLE_APP_USER);
        Person creator = new Person("John", "Doe", "john.doe@example.com", user);
        LocalDate deadline = LocalDate.now().plusDays(10); // Future date

        TodoItem item = new TodoItem("Test Task", deadline, "Test Description", creator);

        assertEquals("Test Task", item.getTitle());
        assertEquals(deadline, item.getDeadLine());
        assertEquals("Test Description", item.getTaskDescription());
        assertEquals(creator, item.getCreator());
        assertFalse(item.isDone());
    }

    @Test
    void testSetTitleValid() {
        TodoItem item = new TodoItem("Initial Title", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        item.setTitle("Updated Title");
        assertEquals("Updated Title", item.getTitle());
    }

    @Test
    void testSetTitleInvalid() {
        TodoItem item = new TodoItem("Initial Title", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        assertThrows(IllegalArgumentException.class, () -> item.setTitle(""));
        assertThrows(IllegalArgumentException.class, () -> item.setTitle(null));
    }

    @Test
    void testSetDeadLineValid() {
        TodoItem item = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        LocalDate newDeadline = LocalDate.now().plusDays(20); // Future date
        item.setDeadLine(newDeadline);
        assertEquals(newDeadline, item.getDeadLine());
    }

    @Test
    void testSetDeadLineInvalid() {
        TodoItem item = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        LocalDate pastDeadline = LocalDate.now().minusDays(10); // Past date
        assertThrows(IllegalArgumentException.class, () -> item.setDeadLine(pastDeadline));
        assertThrows(IllegalArgumentException.class, () -> item.setDeadLine(null));
    }

    @Test
    void testSetDone() {
        TodoItem item = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        assertFalse(item.isDone());
        item.setDone(true);
        assertTrue(item.isDone());
    }

    @Test
    void testEqualsAndHashCode() {
        Person creator = new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER));
        TodoItem item1 = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", creator);
        TodoItem item2 = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", creator);

        assertNotEquals(item1, item2); // Different IDs
        assertNotEquals(item1.hashCode(), item2.hashCode());
    }
}
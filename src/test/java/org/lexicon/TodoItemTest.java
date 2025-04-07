package org.lexicon;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    @Test
    void testTodoItemCreation() {
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem todoItem = new TodoItem("Task 1", LocalDate.now().plusDays(1), "Description", creator);
        assertEquals("Task 1", todoItem.getTitle());
        assertEquals("Description", todoItem.getTaskDescription());
        assertEquals(creator, todoItem.getCreator());
    }

    @Test
    void testInvalidTitle() {
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem("", LocalDate.now().plusDays(1), "Description", creator);
        });
        assertEquals("Title cannot be empty.", exception.getMessage());
    }

    @Test
    void testInvalidDeadline() {
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem("Task 1", LocalDate.now().minusDays(1), "Description", creator);
        });
        assertEquals("Deadline must be in the future.", exception.getMessage());
    }

    @Test
    void testInvalidCreator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TodoItem("Task 1", LocalDate.now().plusDays(1), "Description", null);
        });
        assertEquals("A task must have a creator.", exception.getMessage());
    }
}
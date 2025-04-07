package org.lexicon;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    @Test
    void testTodoItemTaskCreation() {
        Person assignee = new Person("John", "Doe", "john.doe@example.com");
        TodoItem task = new TodoItem("Task 1", LocalDate.now().plusDays(1), "Description", assignee);
        TodoItemTask todoItemTask = new TodoItemTask(task, assignee);
        assertEquals(task, todoItemTask.getTask());
        assertEquals(assignee, todoItemTask.getAssignee());
        assertTrue(todoItemTask.isAssigned());
    }

    @Test
    void testInvalidTask() {
        Person assignee = new Person("John", "Doe", "john.doe@example.com");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TodoItemTask(null, assignee);
        });
        assertEquals("Task cannot be null.", exception.getMessage());
    }

    @Test
    void testInvalidAssignee() {
        Person creator = new Person("John", "Doe", "john.doe@example.com");
        TodoItem task = new TodoItem("Task 1", LocalDate.now().plusDays(1), "Description", creator);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TodoItemTask(task, null);
        });
        assertEquals("Assignee cannot be null", exception.getMessage());
    }
}
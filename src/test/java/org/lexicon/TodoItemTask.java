package org.lexicon;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    @Test
    void testConstructorAndGetters() {
        TodoItem task = new TodoItem("Test Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        Person assignee = new Person("Jane", "Doe", "jane.doe@example.com", new AppUser("assignee", "password", AppRole.ROLE_APP_USER));

        TodoItemTask todoItemTask = new TodoItemTask(task, assignee);

        assertEquals(task, todoItemTask.getTask());
        assertEquals(assignee, todoItemTask.getAssignee());
        assertTrue(todoItemTask.isAssigned());
    }

    @Test
    void testSetTaskValid() {
        TodoItem task1 = new TodoItem("Task 1", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        TodoItem task2 = new TodoItem("Task 2", LocalDate.now().plusDays(20), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        Person assignee = new Person("Jane", "Doe", "jane.doe@example.com", new AppUser("assignee", "password", AppRole.ROLE_APP_USER));

        TodoItemTask todoItemTask = new TodoItemTask(task1, assignee);
        todoItemTask.setTask(task2);

        assertEquals(task2, todoItemTask.getTask());
    }

    @Test
    void testSetTaskInvalid() {
        TodoItem task = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        Person assignee = new Person("Jane", "Doe", "jane.doe@example.com", new AppUser("assignee", "password", AppRole.ROLE_APP_USER));

        TodoItemTask todoItemTask = new TodoItemTask(task, assignee);

        assertThrows(IllegalArgumentException.class, () -> todoItemTask.setTask(null));
    }

    @Test
    void testSetAssigneeValid() {
        TodoItem task = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        Person assignee1 = new Person("Jane", "Doe", "jane.doe@example.com", new AppUser("assignee1", "password", AppRole.ROLE_APP_USER));
        Person assignee2 = new Person("John", "Smith", "john.smith@example.com", new AppUser("assignee2", "password", AppRole.ROLE_APP_USER));

        TodoItemTask todoItemTask = new TodoItemTask(task, assignee1);
        todoItemTask.setAssignee(assignee2);

        assertEquals(assignee2, todoItemTask.getAssignee());
        assertTrue(todoItemTask.isAssigned());
    }

    @Test
    void testSetAssigneeInvalid() {
        TodoItem task = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        Person assignee = new Person("Jane", "Doe", "jane.doe@example.com", new AppUser("assignee", "password", AppRole.ROLE_APP_USER));

        TodoItemTask todoItemTask = new TodoItemTask(task, assignee);

        assertThrows(IllegalArgumentException.class, () -> todoItemTask.setAssignee(null));
    }

    @Test
    void testEqualsAndHashCode() {
        TodoItem task = new TodoItem("Task", LocalDate.now().plusDays(10), "Description", new Person("John", "Doe", "john.doe@example.com", new AppUser("user", "password", AppRole.ROLE_APP_USER)));
        Person assignee = new Person("Jane", "Doe", "jane.doe@example.com", new AppUser("assignee", "password", AppRole.ROLE_APP_USER));

        TodoItemTask todoItemTask1 = new TodoItemTask(task, assignee);
        TodoItemTask todoItemTask2 = new TodoItemTask(task, assignee);

        assertNotEquals(todoItemTask1, todoItemTask2); // Different IDs
        assertNotEquals(todoItemTask1.hashCode(), todoItemTask2.hashCode());
    }
}
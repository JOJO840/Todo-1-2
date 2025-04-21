// TodoItem.java
package org.lexicon.model;

import org.lexicon.dao.sequencer.TodoItemSequencer;
import org.lexicon.dao.sequencer.TodoItemTaskIdSequencer;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    private int id;

    public TodoItem(String title, LocalDate deadLine, String taskDescription, Person creator) {
        this.id = TodoItemSequencer.nextId();
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setCreator(creator);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public Person getCreator() {
        return creator;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null || deadLine.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Deadline must be in the future.");
        }
        this.deadLine = deadLine;
    }

    public void setCreator(Person creator) {
        if (creator == null) {
            throw new IllegalArgumentException("A task must have a creator.");
        }
        this.creator = creator;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(deadLine);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id= " + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return done == todoItem.done &&
                id == todoItem.id &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(taskDescription, todoItem.taskDescription) &&
                Objects.equals(deadLine, todoItem.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, taskDescription, deadLine, done, id);
    }
}
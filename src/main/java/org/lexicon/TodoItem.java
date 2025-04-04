package org.lexicon;

import java.time.LocalDate;

public class TodoItem {
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    private int id;
    private static int counter = 0;

    public TodoItem(String title, LocalDate deadLine, String taskDescription, Person creator) {
        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        this.id = ++counter;

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
        if (title == null || title.trim().isEmpty())
            throw new IllegalArgumentException("Title cannot be empty.");
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null || deadLine.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Deadline must be in the future.");
        this.deadLine = deadLine;
    }

    public void setCreator(Person creator) {
        if (creator == null)
            throw new IllegalArgumentException("A task must have a creator.");
        this.creator = creator;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone(){
        return done;
    }

    public boolean isOverdue(){
        return LocalDate.now().isAfter(deadLine);
    }

    public String getSummary() {
        return "Task ID: " + id + ", Title: " + title + ", Done: " + done + ", Overdue: " + isOverdue();

    }


}

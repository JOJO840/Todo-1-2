// TodoItemTask.java
package org.lexicon;

import java.util.Objects;

public class TodoItemTask {
    private boolean assigned;
    private TodoItem task;
    private Person assignee;
    private int id;
    private static int counter;

    public TodoItemTask(TodoItem task, Person assignee) {
        this.id = ++counter;
        setTask(task);
        setAssignee(assignee);
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTask() {
        return task;
    }

    public void setTask(TodoItem task) {
        if (task == null) {
            throw new IllegalArgumentException("TodoItem cannot be null.");
        }
        this.task = task;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException("Assignee cannot be null");
        }
        this.assignee = assignee;
        this.assigned = true;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "assigned=" + assigned +
                ", task=" + task +
                ", assignee=" + assignee +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask)) return false;
        TodoItemTask that = (TodoItemTask) o;
        return assigned == that.assigned &&
                id == that.id &&
                Objects.equals(task, that.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assigned, task, id);
    }
}
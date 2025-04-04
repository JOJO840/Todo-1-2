package org.lexicon;

public class TodoItemTask {
    private int id; // is an int representing each TodoItemTask object
    private boolean assigned; //represent the details what assignee should do before
    private TodoItem task; //represent the details what assignee should do before deadline. Not null
    private Person assignee; // ) is the Person being assigned to do the Task.

    public TodoItemTask(int id, TodoItem task, Person assignee) {
        this.id = id;
        this.task = task;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.task = task;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public String getSummary() {
        return "Task ID: " + id;
    }
}

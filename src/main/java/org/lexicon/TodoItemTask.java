package org.lexicon;

public class TodoItemTask {
    private boolean assigned; //represent the details what assignee should do before
    private TodoItem task; //represent the details what assignee should do before deadline. Not null
    private Person assignee; // ) is the Person being assigned to do the Task.
    private int id; // is an int representing each TodoItemTask object
    private static int counter; // is an int representing each TodoItemTask object

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
            throw new IllegalArgumentException("Task cannot be null.");
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

    public String getSummary() {
        return "Summary: " + assignee.getSummary() +
                " , \n" + task.getSummary() +
                "\n" + task.getTaskDescription();

    }
}

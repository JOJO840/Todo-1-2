package org.lexicon;

import java.time.LocalDate;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;


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
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone(){
        return false;
    }

    public boolean isOverdue(){
        return false;
    }

    public String getSummary(){
        return "";
    }


}

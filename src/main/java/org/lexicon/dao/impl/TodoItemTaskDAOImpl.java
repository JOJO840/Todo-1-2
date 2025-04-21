package org.lexicon.dao.impl;

import org.lexicon.dao.interfaces.TodoItemTaskDAO;
import org.lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TodoItemTaskDAOImpl implements TodoItemTaskDAO {

    private final List<TodoItemTask> todoItemTaskList = new ArrayList<>();

    @Override
    public void persist(TodoItemTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        todoItemTaskList.add(task);
    }

    @Override
    public TodoItemTask findById(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be greater than 0.");
        for (TodoItemTask task : todoItemTaskList){
            if (task.getId() == id) return task;
        } throw new NoSuchElementException("No TodoItemTask found with ID: " + id);
    }

    @Override
    public List<TodoItemTask> findAll() {
        return todoItemTaskList;
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean assigned) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task : todoItemTaskList){
            if (task.isAssigned() == assigned) result.add(task);
        } return result;
    }

    @Override
    public List<TodoItemTask> findByPersonId(int personId) {
        List<TodoItemTask> result = new ArrayList<>();
        for (TodoItemTask task:todoItemTaskList){
            if (task.getAssignee().getId() == personId) result.add(task);
        }return result;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < todoItemTaskList.size(); i++) {
            if (todoItemTaskList.get(i).getId() == id) {
                TodoItemTask removed = todoItemTaskList.remove(i);
                System.out.println("Removed task: " + removed);
                return;
            }
        }
        System.out.println("No task found with id: " + id);
    }

    @Override
    public String toString() {
        return "TodoItemTaskDAOImpl{" +
                "todoItemTaskList=" + todoItemTaskList +
                '}';
    }
}

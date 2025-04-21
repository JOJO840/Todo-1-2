package org.lexicon.dao.impl;

import org.lexicon.dao.interfaces.TodoItemDAO;
import org.lexicon.model.TodoItem;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoItemDAOImpl implements TodoItemDAO {

    private final List<TodoItem> todoItemList = new ArrayList<>();

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("todoItem cannot be null.");
        }
        todoItemList.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem item : todoItemList){
            if (item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public List<TodoItem> findAll() {
        return todoItemList;
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(boolean done) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.isDone() == done) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<TodoItem> findByTitleContains(String title) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getTitle().equals(title)) { result.add(item);
            }
        } return result;
    }

    @Override
    public List<TodoItem> findByPersonId(int personId) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getId() == personId) result.add(item);
        } return result;
    }

    @Override
    public List<TodoItem> findByDeadLineBefore(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getDeadLine().isBefore(date)) result.add(item);
        } return result;
    }

    @Override
    public List<TodoItem> findByDeadLineAfter(LocalDate date) {
        List<TodoItem> result = new ArrayList<>();
        for (TodoItem item : todoItemList){
            if (item.getDeadLine().isAfter(date)) result.add(item);
        } return result;
    }


    @Override
    public void remove(int id) {
        for (int i = 0; i < todoItemList.size(); i++) {
            if (todoItemList.get(i).getId() == id) {
                TodoItem removed = todoItemList.remove(i);
                System.out.println("Removed item: " + removed);
                return; // Stop after removing
            }
        }
        System.out.println("No item found with id: " + id);
    }

    @Override
    public String toString() {
        return "TodoItemDAOImpl{" +
                "todoItemList=" + todoItemList +
                '}';
    }
}

package org.lexicon.dao.interfaces;

import org.lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.List;

public interface TodoItemDAO {
    TodoItem persist(TodoItem todoItem);
    TodoItem findById(int id);
    List<TodoItem> findAll();
    List<TodoItem>findAllByDoneStatus(boolean done);
    List<TodoItem> findByTitleContains(String title);
    List<TodoItem> findByPersonId(int personId);
    List<TodoItem>findByDeadLineBefore(LocalDate date);
    List<TodoItem>findByDeadLineAfter(LocalDate date);
    void remove(int id);



}

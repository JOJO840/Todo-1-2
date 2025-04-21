package org.lexicon.dao.interfaces;

import org.lexicon.model.TodoItemTask;

import java.util.List;

public interface TodoItemTaskDAO {
    void persist(TodoItemTask task);
    TodoItemTask findById(int id);
    List<TodoItemTask> findAll();
    List<TodoItemTask> findByAssignedStatus(boolean assigned);
    List<TodoItemTask> findByPersonId(int personId);
    void remove(int id);
}

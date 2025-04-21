package org.lexicon;


import org.lexicon.dao.impl.AppUserDAOImpl;
import org.lexicon.dao.impl.PersonDAOImpl;
import org.lexicon.dao.impl.TodoItemDAOImpl;
import org.lexicon.dao.impl.TodoItemTaskDAOImpl;
import org.lexicon.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // testing AppUser,AppUserDAOImpl
        AppUser appUser1 = new AppUser("Josip424", "1111111111", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("G415", "1111111112", AppRole.ROLE_APP_USER);
        AppUserDAOImpl appUserDAOImpl = new AppUserDAOImpl();
        appUserDAOImpl.persist(appUser1);
        System.out.println(appUserDAOImpl.findByUserName("Josip424"));
        appUserDAOImpl.remove("Josip424");
        System.out.println(appUserDAOImpl.findall());
        System.out.println("-----------------------------");

        // testing Person,PersonDAOImpl
        Person p1 = new Person("Josip", "J", "j@gmail.com", appUser1);
        Person p2 = new Person("G", "G", "g@gmail.com", appUser2);
        PersonDAOImpl personDAO = new PersonDAOImpl();
        personDAO.persist(p1);
        personDAO.persist(p2);
        System.out.println("findById: " + personDAO.findById(1));
        System.out.println("findById: " + personDAO.findById(2));
        System.out.println("personDAO1.findByEmail(\"j@gmail.com\") = " + personDAO.findByEmail("j@gmail.com"));
        System.out.println("personDAO1.findAll() = " + personDAO.findAll());
        //personDAO.remove(1);
        System.out.println("personDAO.findAll() = " + personDAO.findAll());
        System.out.println("----------------------------");

            // testing TodoItem,TodoItemDAOImpl
        TodoItem todoItem1 = new TodoItem("buy car", LocalDate.now().plusMonths(4), "buy car before 4 months",p1);
        TodoItem todoItem2 = new TodoItem("buy house", LocalDate.now().plusMonths(8), "buy house before 8 months",p2);
        System.out.println(todoItem1);
        System.out.println("todoItem.isDone() = " + todoItem1.isDone());
        todoItem1.setDone(true);
        System.out.println("todoItem.isDone() = " + todoItem1.isDone());
        TodoItemDAOImpl todoItemDAO = new TodoItemDAOImpl();
        todoItemDAO.persist(todoItem1);
        System.out.println("todoItemDAO.findAll() = " + todoItemDAO.findAll());
        System.out.println("Done items: " + todoItemDAO.findAllByDoneStatus(true));
        System.out.println("Not done items: " + todoItemDAO.findAllByDoneStatus(false));
        System.out.println("todoItemDAO.findByTitleContains(\"buy car\") = " + todoItemDAO.findByTitleContains("buy car"));
        System.out.println("todoItemDAO.findByPersonId(1) = " + todoItemDAO.findByPersonId(1));
        // todoItemDAO.remove(1); remove todoItem by ID
        System.out.println("todoItemDAO.findAll() = " + todoItemDAO.findAll());
        System.out.println(".------------------------------------");
        
            // testing TodoItem,TodoItemDAOImpl
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem1,p1);
        TodoItemTask todoItemTask2 = new TodoItemTask(todoItem2,p2);
        TodoItemTaskDAOImpl todoItemTaskDAO = new TodoItemTaskDAOImpl();
        todoItemTaskDAO.persist(todoItemTask1);
        todoItemTaskDAO.persist(todoItemTask2);
        System.out.println("todoItemTaskDAO.findById(1) = " + todoItemTaskDAO.findById(1));
        System.out.println("todoItemTaskDAO.findById(1) = " + todoItemTaskDAO.findById(2));
        System.out.println("todoItemTaskDAO.findAll() = " + todoItemTaskDAO.findAll());
        todoItemTaskDAO.remove(1);
        System.out.println("todoItemTaskDAO.findByPersonId(2) = " + todoItemTaskDAO.findByPersonId(2));
        System.out.println("todoItemTaskDAO.findAll() = " + todoItemTaskDAO.findAll());


        


        


    }
}
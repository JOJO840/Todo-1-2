package org.lexicon.dao.impl;

import org.lexicon.dao.interfaces.AppUserDAO;
import org.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDAOImpl implements AppUserDAO {

    private final List<AppUser> appUsers = new ArrayList<>();


    @Override
    public AppUser persist(AppUser appUser) {
        appUsers.add(appUser);
        return appUser;
    }

    @Override
    public AppUser findByUserName(String username) {
        for (AppUser s : appUsers){
            if (s.getUsername().equals(username)){
                return s;
            }
        }
        return null;
    }

    @Override
    public List<AppUser> findall() {
        return appUsers;
    }

    @Override
    public void remove(String username) {
        for (AppUser s : appUsers){
            if (s.getUsername().equals(username)){
                appUsers.remove(s);
                System.out.println("removed: " + username);
                return;
            }
        }
        System.out.println("user not found!: " + username);
    }


    @Override
    public String toString() {
        return "AppUserDAOCollection{" +
                "appUsers=" + appUsers +
                '}';
    }
}

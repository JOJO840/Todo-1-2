package org.lexicon.dao.interfaces;

import org.lexicon.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDAO {

    AppUser persist(AppUser appUser);
    AppUser findByUserName(String username);
    List<AppUser> findall();
    void remove(String username);


}

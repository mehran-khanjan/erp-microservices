package com.relicblock.enterprise.users.services;

import com.relicblock.enterprise.users.dao.UserDAO;
import com.relicblock.enterprise.users.repositories.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersService {

    private UserDAO repo;

    @Autowired
    public UsersService(UserDAO repo) {
        this.repo = repo;
    }

    public User save() {
        // create the user object
        User user = new User(
                "foo",
                "bar",
                "foo",
                "bar",
                "foo",
                "bar"
        );

        // save the user object
        this.repo.save(user);

        // return the new user
        return user;
    }

    public User findBySlug() {
        return this.repo.findBySlug("foo");
    }

    public List<User> findAll() {
        return this.repo.findAll();
    }

    public String update() {
        this.repo.update("foo", "updated foo");
        return "updated.";
    }

    public String delete() {
        this.repo.delete("foo");
        return "deleted.";
    }
}

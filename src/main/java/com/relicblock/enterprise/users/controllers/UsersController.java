package com.relicblock.enterprise.users.controllers;

import com.relicblock.enterprise.users.repositories.User;
import com.relicblock.enterprise.users.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public User create() {
        return this.usersService.save();
    }

    @GetMapping("/{userSlug}")
    public User read(@PathVariable String userSlug) {
        return this.usersService.findBySlug();
    }

    @GetMapping
    public List<User> readAll() {
        return this.usersService.findAll();
    }

    @PatchMapping("/{userSlug}")
    public String update(@PathVariable String userSlug) {
        return this.usersService.update();
    }

    @DeleteMapping("/{userSlug}")
    public String delete(@PathVariable String userSlug) {
        return this.usersService.delete();
    }


}

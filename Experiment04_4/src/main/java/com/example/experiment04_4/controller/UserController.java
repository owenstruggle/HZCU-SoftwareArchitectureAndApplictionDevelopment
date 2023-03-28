package com.example.experiment04_4.controller;

import com.example.experiment04_4.entity.UserDAO;
import com.example.experiment04_4.service.impl.UserServerImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:46
 * @description TODO
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServerImpl userServer;

    @GetMapping("/list")
    public List<UserDAO> getAll() {
        return userServer.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDAO getUser(@PathVariable Long id) {
        return userServer.getUser(id);
    }

    @PostMapping("")
    public boolean addUser(UserDAO user) {
        return userServer.addUser(user);
    }

    @PutMapping("")
    public boolean putUser(UserDAO user) {
        return userServer.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userServer.deleteUser(id);
    }
}

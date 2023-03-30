package com.example.experiment05_4.controller;

import com.example.experiment05_4.config.UserConfig;
import com.example.experiment05_4.entity.User;
import com.example.experiment05_4.service.impl.UserServerImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Owem
 * @date 2023/3/30 14:55
 * @description TODO
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServerImpl userServer;

    @RequestMapping
    public Map<String, Object> handleError() {
        //用Map容器返回信息
        Map<String, Object> map = new HashMap<>();
        map.put("code", 404);
        map.put("msg", "不存在");
        return map;
    }

    @GetMapping("/example")
    public User example() {
        return new UserConfig().example();
    }

    @GetMapping("/list")
    public List<User> getAll() {
        return userServer.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userServer.getUser(id);
    }

    @PostMapping("")
    public boolean addUser(User user) {
        return userServer.addUser(user);
    }

    @PutMapping("")
    public boolean putUser(User user) {
        return userServer.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userServer.deleteUser(id);
    }
}

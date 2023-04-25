package com.example.experiment07_2.controller;


import com.example.experiment07_2.entity.Result;
import com.example.experiment07_2.entity.UserDAO;
import com.example.experiment07_2.service.impl.UserServerImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:46
 * @description TODO
 **/
@RestController
public class UserController {
    @Resource
    UserServerImpl userServer;

    @GetMapping("/allUser")
    public Result getAllUser(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDAO> userList = userServer.getAllUser();
        PageInfo<UserDAO> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo);
        return Result.SUCCESS("获取成功", pageInfo);
    }

    @PostMapping("/add")
    public Result addUser(@RequestBody UserDAO user) {
        return userServer.addUser(user);
    }

    @GetMapping("/user")
    public Result getUser(@RequestParam("id") String id) {
        return userServer.getUser(id);
    }

    @DeleteMapping("/delete")
    public Result deleteUser(@RequestBody() HashMap<String, Object>map) {
        if (map.containsKey("id")) {
            return userServer.deleteUser((String) map.get("id"));
        }
        return Result.ERROR("id 获取失败", new HashMap<>());
    }

    @PostMapping("/update")
    public Result updateUser(@RequestBody() UserDAO user) {
        return userServer.updateUser(user);
    }
}

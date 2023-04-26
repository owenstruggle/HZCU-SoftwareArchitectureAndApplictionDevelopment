package com.example.experiment08_2.controller;


import com.example.experiment08_2.entity.Result;
import com.example.experiment08_2.entity.UserDAO;
import com.example.experiment08_2.service.impl.UserServerImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(summary = "获取全部用户数据")
    @GetMapping("/allUser")
    public Result getAllUser(@RequestParam("pageNum") @Parameter(description = "页码") int pageNum,
                             @RequestParam("pageSize") @Parameter(description = "页大小") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UserDAO> userList = userServer.getAllUser();
        PageInfo<UserDAO> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo);
        return Result.SUCCESS("获取成功", pageInfo);
    }

    @Operation(summary = "添加用户数据")
    @PostMapping("/add")
    public Result addUser(@RequestBody @Parameter(description = "用户对象") UserDAO user) {
        return userServer.addUser(user);
    }

    @Operation(summary = "获取指定用户数据")
    @GetMapping("/user")
    public Result getUser(@RequestParam("id") @Parameter(description = "用户 id") String id) {
        return userServer.getUser(id);
    }

    @Operation(summary = "删除指定用户数据")
    @DeleteMapping("/delete")
    public Result deleteUser(@RequestBody() @Parameter(description = "包含用户 id 的 map 对象") HashMap<String, Object> map) {
        if (map.containsKey("id")) {
            return userServer.deleteUser((String) map.get("id"));
        }
        return Result.ERROR("id 获取失败", new HashMap<>());
    }

    @Operation(summary = "更新用户数据")
    @PutMapping("/update")
    public Result updateUser(@RequestBody() @Parameter(description = "用户对象") UserDAO user) {
        return userServer.updateUser(user);
    }
}

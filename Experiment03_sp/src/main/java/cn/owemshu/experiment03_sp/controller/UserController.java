package cn.owemshu.experiment03_sp.controller;


import cn.owemshu.experiment03_sp.entity.Result;
import cn.owemshu.experiment03_sp.entity.UserDAO;
import cn.owemshu.experiment03_sp.service.impl.UserServerImpl;
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

    @PutMapping("/add")
    public Result addUser(@RequestBody UserDAO user) {
        return userServer.addUser(user);
    }

    @GetMapping("/user")
    public Result getUser(@RequestParam("id") String id) {
        return userServer.getUser(id);
    }
}

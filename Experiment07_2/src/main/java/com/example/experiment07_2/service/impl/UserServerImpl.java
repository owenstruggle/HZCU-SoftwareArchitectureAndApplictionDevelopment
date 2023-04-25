package com.example.experiment07_2.service.impl;


import com.example.experiment07_2.entity.Result;
import com.example.experiment07_2.entity.UserDAO;
import com.example.experiment07_2.mapper.UserMapper;
import com.example.experiment07_2.service.intf.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
@Service
public class UserServerImpl implements UserServer {
    @Resource
    UserMapper userMapper;

    @Override
    public List<UserDAO> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public Result addUser(UserDAO user) {
        if (userMapper.addUser(user) == 1L) {
            return Result.SUCCESS("插入成功", new HashMap<>());
        }
        return Result.ERROR("插入失败", new HashMap<>());
    }

    @Override
    public Result getUser(String id) {
        UserDAO user = userMapper.getUser(id);
        HashMap<String, Object> map = new HashMap<>();
        if (id.equals(user.getId())) {
            map.put("user", user);
            return Result.SUCCESS("获取成功", map);
        }
        return Result.SUCCESS("获取失败", map);
    }

    @Override
    public Result deleteUser(String id) {
        if (userMapper.deleteUser(id) == 1L) {
            return Result.SUCCESS("删除成功", new HashMap<>());
        }
        return Result.ERROR("删除失败", new HashMap<>());
    }

    @Override
    public Result updateUser(UserDAO user) {
        if (userMapper.updateUser(user) == 1L) {
            return Result.SUCCESS("更新成功", new HashMap<>());
        }
        return Result.ERROR("更新失败", new HashMap<>());
    }
}

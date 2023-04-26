package com.example.experiment08_2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.experiment08_2.entity.Result;
import com.example.experiment08_2.entity.UserDAO;
import com.example.experiment08_2.mapper.UserMapper;
import com.example.experiment08_2.service.intf.UserServer;
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
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public Result addUser(UserDAO user) {
        if (userMapper.insert(user) != 1)
            return Result.ERROR("error", new HashMap<>());
        return Result.SUCCESS("success", new HashMap<>());
    }

    @Override
    public Result getUser(String id) {
        QueryWrapper<UserDAO> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        HashMap<String, Object> map = new HashMap<>();
        if (userMapper.selectCount(wrapper) != 1) {
            return Result.ERROR("error", map);
        }
        UserDAO user = userMapper.selectById(id);
        map.put("user", user);
        return Result.SUCCESS("success", map);
    }

    @Override
    public Result deleteUser(String id) {
        if (id == null || id.equals("")) {
            return Result.ERROR("id 获取失败", new HashMap<>());
        }

        if (userMapper.selectCount(new QueryWrapper<UserDAO>().eq("id", id)) == 1) {
            if (userMapper.deleteById(id) == 1) {
                return Result.SUCCESS("删除成功", new HashMap<>());
            }
        }
        return Result.ERROR("获取失败", new HashMap<>());
    }

    @Override
    public Result updateUser(UserDAO user) {
        if (user.getId() == null || user.getId().equals("")) {
            return Result.ERROR("id 获取失败", new HashMap<>());
        }

        if (userMapper.selectCount(new QueryWrapper<UserDAO>().eq("id", user.getId())) == 1) {
            if (userMapper.update(user, new QueryWrapper<UserDAO>().eq("id", user.getId())) == 1) {
                return Result.SUCCESS("更新成功", new HashMap<>());
            }
        }
        return Result.ERROR("获取失败", new HashMap<>());
    }
}

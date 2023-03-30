package com.example.experiment05_4.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.experiment05_4.entity.User;
import com.example.experiment05_4.mapper.UserMapper;
import com.example.experiment05_4.service.intf.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public List<User> getAllUser() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public User getUser(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.insert(user) == 1L;
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.update(user, new QueryWrapper<User>().eq("id", user.getId())) == 1;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteById(id) == 1L;
    }
}

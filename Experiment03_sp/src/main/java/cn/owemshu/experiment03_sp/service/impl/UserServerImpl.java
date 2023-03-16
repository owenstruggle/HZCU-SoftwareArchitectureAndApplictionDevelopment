package cn.owemshu.experiment03_sp.service.impl;


import cn.owemshu.experiment03_sp.entity.Result;
import cn.owemshu.experiment03_sp.entity.UserDAO;
import cn.owemshu.experiment03_sp.mapper.UserMapper;
import cn.owemshu.experiment03_sp.service.intf.UserServer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
        if (userMapper.selectCount(wrapper) != 1)
            return Result.ERROR("error", map);
        UserDAO user = userMapper.selectById(id);
        map.put("user", user);
        return Result.SUCCESS("success", map);
    }
}

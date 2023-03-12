package cn.owemshu.experiment02_3.service.impl;

import cn.owemshu.experiment02_3.mapper.UserMapper;
import cn.owemshu.experiment02_3.model.entity.UserDAO;
import cn.owemshu.experiment02_3.service.intf.UserServer;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public List<UserDAO> getAllUser() {
        return userMapper.selectList(new QueryWrapper<>());
    }
}

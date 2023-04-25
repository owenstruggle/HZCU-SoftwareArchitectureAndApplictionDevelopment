package com.example.experiment07_1.service.intf;


import com.example.experiment07_1.entity.Result;
import com.example.experiment07_1.entity.User;

import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
public interface UserServer {
    List<User> getAllUser();

    Result addUser(User user);

    Result getUser(String id);

    Result deleteUser(String id);

    Result updateUser(User user);
}

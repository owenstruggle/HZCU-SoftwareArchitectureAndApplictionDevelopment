package com.example.experiment09_1.service.intf;


import com.example.experiment09_1.entity.Result;
import com.example.experiment09_1.entity.UserDAO;

import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
public interface UserServer {
    List<UserDAO> getAllUser();

    Result addUser(UserDAO user);

    Result getUser(String id);

    Result deleteUser(String id);

    Result updateUser(UserDAO user);
}

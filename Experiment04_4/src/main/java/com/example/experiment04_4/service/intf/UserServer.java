package com.example.experiment04_4.service.intf;


import com.example.experiment04_4.entity.UserDAO;

import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
public interface UserServer {
    List<UserDAO> getAllUser();

    UserDAO getUser(Long id);

    boolean addUser(UserDAO user);

    boolean updateUser(UserDAO user);

    boolean deleteUser(Long id);
}

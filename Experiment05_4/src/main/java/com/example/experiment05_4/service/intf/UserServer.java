package com.example.experiment05_4.service.intf;


import com.example.experiment05_4.entity.User;

import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
public interface UserServer {
    List<User> getAllUser();

    User getUser(Long id);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(Long id);
}

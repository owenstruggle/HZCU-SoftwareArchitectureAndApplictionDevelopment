package com.example.experiment07_1.dao;

import com.example.experiment07_1.entity.User;

import java.util.List;

/**
 * @author Owem
 * @date 2023/4/25 15:19
 * @description TODO
 **/

public interface UserDAO {
    List<User> getAllUser();

    void addUser(User user);

    User getUser(String id);

    void deleteUser(String id);

    void updateUser(User user);
}

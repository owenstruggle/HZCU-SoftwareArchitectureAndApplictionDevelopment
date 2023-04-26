package com.example.experiment08_2.service.intf;




import com.example.experiment08_2.entity.Result;
import com.example.experiment08_2.entity.UserDAO;

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

    Result updateUser (UserDAO user);
}

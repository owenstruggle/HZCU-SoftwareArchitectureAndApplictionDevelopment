package cn.owemshu.experiment03_sp.service.intf;



import cn.owemshu.experiment03_sp.entity.Result;
import cn.owemshu.experiment03_sp.entity.UserDAO;

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

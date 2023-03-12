package cn.owemshu.experiment02_3.service.intf;

import cn.owemshu.experiment02_3.model.entity.UserDAO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
public interface UserServer {
    List<UserDAO> getAllUser();
}

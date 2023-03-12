package cn.owemshu.experiment02_3.controller;

import cn.owemshu.experiment02_3.model.entity.UserDAO;
import cn.owemshu.experiment02_3.service.impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:46
 * @description TODO
 **/
@RestController
public class TestController {
    @Resource
    UserServerImpl userServer;
    @Value("${parameter.randomInt}")
    int randomInt;
    @Value("${parameter.randomString}")
    String randomString;
    @Value("${parameter.school}")
    String school;
    @Value("${parameter.class}")
    String _class;

    @GetMapping("/")
    public String test() {
        return  "randomInt = " + randomInt + "\trandomString = " + randomString + "\tschool = " + school + "\tclass = " + _class;
    }

    @GetMapping("/database")
    public String databaseTest() {
        List<UserDAO> userList = userServer.getAllUser();
        return userList.toString();
    }
}

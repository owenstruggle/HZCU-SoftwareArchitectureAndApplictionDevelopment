package cn.edu.zucc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zucc
 * @version 1.0
 * @date 2021/03/14 10:56
 */
@RestController
public class HelloZuccController {
    @Value("${usersetting.year}")
    String year;
    @Value("${usersetting.number}")
    int number;
    @Autowired
    private OurSchool ourSchool;

    @RequestMapping("/school")
    public String hello() {
        return ourSchool.getName();
    }

    @RequestMapping("/test")
    public String test() {
        return "配置文件随机生成的内容 {year = " + year + "}, {number = " + number + "}";
    }
}


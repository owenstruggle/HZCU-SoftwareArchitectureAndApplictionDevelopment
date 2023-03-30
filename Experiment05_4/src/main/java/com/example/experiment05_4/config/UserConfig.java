package com.example.experiment05_4.config;

import com.example.experiment05_4.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Owem
 * @date 2023/3/30 14:23
 * @description TODO
 **/
@Configuration
public class UserConfig {
    //将此返回的值生成一个bean
    @Bean("example")
    public User example() {
        User user = new User();
        user.setId(32001212);
        user.setName("牢笼里");
        user.setGender(true);
        user.setEmail("lll@163.com");
        user.setIdentityCard("11010519491231002X");
        return user;
    }
}

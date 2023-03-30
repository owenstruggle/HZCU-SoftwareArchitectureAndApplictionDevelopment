package com.example.experiment05_2.config;

import com.example.experiment05_2.entity.User;
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
    @Bean("user1")
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("longzhiran");
        return user;
    }
}

package com.example.experiment05_2.controller;

import com.example.experiment05_2.config.UserConfig;
import com.example.experiment05_2.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Owem
 * @date 2023/3/30 14:26
 * @description TODO
 **/
@RestController
public class UserController {
    @GetMapping("")
    public User test() {
        return new UserConfig().user();
    }
}

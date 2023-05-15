package com.example.experiment09_1.controller;

import com.example.experiment09_1.entity.AccountDAO;
import com.example.experiment09_1.entity.Result;
import com.example.experiment09_1.service.impl.AccountServerImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Owem
 * @date 2023/5/15 08:35
 * @description TODO
 **/
@RestController
public class LoginController {
    @Resource
    AccountServerImpl accountServer;

    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result userLogin(@RequestBody @Parameter(description = "用户对象") AccountDAO account) {
        return accountServer.accountLogin(account);
    }
}

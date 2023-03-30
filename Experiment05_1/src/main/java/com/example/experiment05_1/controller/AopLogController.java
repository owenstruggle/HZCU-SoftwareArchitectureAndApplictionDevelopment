package com.example.experiment05_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Owem
 * @date 2023/3/30 14:20
 * @description TODO
 **/
@RestController
public class AopLogController {
    @GetMapping("/aoptest")
    public String aVoid(){
        return "hello aop test";
    }
    @GetMapping("/new")
    public String aNew(){
        return "new GetMapping";
    }
}

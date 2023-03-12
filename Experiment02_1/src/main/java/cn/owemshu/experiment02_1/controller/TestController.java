package cn.owemshu.experiment02_1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Owem
 * @date 2023/3/12 14:18
 * @description TODO
 **/
@RestController
public class TestController {
    @GetMapping("/")
    public String test() {
        return "Hello World";
    }
}

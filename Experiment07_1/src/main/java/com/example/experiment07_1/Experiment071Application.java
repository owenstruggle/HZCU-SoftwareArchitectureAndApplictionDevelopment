package com.example.experiment07_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.experiment07_1.dao")
public class Experiment071Application {

    public static void main(String[] args) {
        SpringApplication.run(Experiment071Application.class, args);
    }

}

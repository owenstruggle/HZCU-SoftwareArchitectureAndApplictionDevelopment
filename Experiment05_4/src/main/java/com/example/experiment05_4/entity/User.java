package com.example.experiment05_4.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Owem
 * @date 2023/3/30 14:24
 * @description TODO
 **/
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String email;
    private boolean gender;
    private String identityCard;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", identityCard='" + identityCard + '\'' +
                '}';
    }
}

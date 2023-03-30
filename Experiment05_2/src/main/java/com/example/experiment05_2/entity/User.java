package com.example.experiment05_2.entity;

import java.io.Serializable;

/**
 * @author Owem
 * @date 2023/3/30 14:24
 * @description TODO
 **/
public class User implements Serializable {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

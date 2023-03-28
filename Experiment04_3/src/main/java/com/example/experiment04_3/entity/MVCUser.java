package com.example.experiment04_3.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author longzhonghua
 * @data 2/20/2019 1:25 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MVCUser {
    private long id;
    private String name;
    private int age;
}

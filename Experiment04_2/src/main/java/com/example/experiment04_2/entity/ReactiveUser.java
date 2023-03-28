package com.example.experiment04_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author longzhonghua
 * @data 2/20/2019 1:25 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReactiveUser {
    private long id;
    private String name;
}

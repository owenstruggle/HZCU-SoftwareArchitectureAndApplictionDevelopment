package com.example.experiment06.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;

/**
 * @author Owem
 * @date 2023/4/17 15:34
 * @description TODO
 **/
@Entity
@Data
public class Article extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "标题不能为空")
    private String title;

    @Column(nullable = false)
    private String body;
}

package com.example.experiment04_4.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Owem
 * @date 2023/3/12 14:51
 * @description TODO
 **/
@Data
@TableName("user")
public class UserDAO {
    @TableId
    private Integer id;
    private String name;
    private String email;
    private boolean gender;
    private String identityCard;
}

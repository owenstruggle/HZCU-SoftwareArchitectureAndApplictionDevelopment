package com.example.experiment09_1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private String id;
    private String name;
    private String email;
    private boolean gender;
    private String identityCard;

    @TableField(exist = false)
    private String accountId;
    @TableField(exist = false)
    private String token;
}

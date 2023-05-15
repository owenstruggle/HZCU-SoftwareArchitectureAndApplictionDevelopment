package com.example.experiment09_1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Owem
 * @date 2023/5/15 08:37
 * @description TODO
 **/
@Data
@TableName("account")
public class AccountDAO {
    @TableId
    private String accountId;
    private String password;
    private int jurisdiction;
}

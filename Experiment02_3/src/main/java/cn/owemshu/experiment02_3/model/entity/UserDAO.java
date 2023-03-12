package cn.owemshu.experiment02_3.model.entity;

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
    private Integer userId;
    private String userName;
}

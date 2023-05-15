package com.example.experiment09_1.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.experiment09_1.entity.UserDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Owem
 * @date 2023/3/12 14:55
 * @description TODO
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserDAO> {

}

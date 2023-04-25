package com.example.experiment07_2.mapper;

import com.example.experiment07_2.entity.UserDAO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:55
 * @description TODO
 **/
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<UserDAO> getAllUser();

    @Insert("insert into user (id, name, email, gender, identity_card) values ('${id}', '${name}', '${email}', ${gender}, '${identityCard}');")
    Long addUser(UserDAO user);

    @Select("select * from user where id = '${id}';")
    UserDAO getUser(String id);

    @Delete("delete from user where id = '${id}';")
    Long deleteUser(String id);

    @Update("update user set name = '${name}', email = '${email}', gender = ${gender}, identity_card = '${identityCard}' where id = '${id}';")
    Long updateUser(UserDAO user);
}

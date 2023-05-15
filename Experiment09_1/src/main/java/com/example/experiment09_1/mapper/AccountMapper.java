package com.example.experiment09_1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.experiment09_1.entity.AccountDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Owem
 * @date 2023/5/15 08:43
 * @description TODO
 **/
@Mapper
public interface AccountMapper extends BaseMapper<AccountDAO> {
}

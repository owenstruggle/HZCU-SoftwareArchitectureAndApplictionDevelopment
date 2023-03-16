package cn.owemshu.experiment03_sp.mapper;

import cn.owemshu.experiment03_sp.entity.UserDAO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Owem
 * @date 2023/3/12 14:55
 * @description TODO
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserDAO> {

}

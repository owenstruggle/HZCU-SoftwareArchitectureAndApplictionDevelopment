package cn.owemshu.experiment02_3.mapper;

import cn.owemshu.experiment02_3.model.entity.UserDAO;
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

package com.example.experiment07_1.service.impl;


import com.example.experiment07_1.dao.UserDAO;
import com.example.experiment07_1.entity.Result;
import com.example.experiment07_1.entity.User;
import com.example.experiment07_1.service.intf.UserServer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author Owem
 * @date 2023/3/12 14:54
 * @description TODO
 **/
@Service
public class UserServerImpl implements UserServer {
    @Override
    public List<User> getAllUser() {
        InputStream inputStream = UserServerImpl.class.getClassLoader().getResourceAsStream("MyBatis-Config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDao = sqlSession.getMapper(UserDAO.class);

        List<User> allUser = userDao.getAllUser();

        sqlSession.close();
        return allUser;
    }

    @Override
    public Result addUser(User user) {
        InputStream inputStream = UserServerImpl.class.getClassLoader().getResourceAsStream("MyBatis-Config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDao = sqlSession.getMapper(UserDAO.class);

        userDao.addUser(user);

        sqlSession.commit();
        sqlSession.close();
        return Result.SUCCESS("插入成功", new HashMap<>());
    }

    @Override
    public Result getUser(String id) {
        InputStream inputStream = UserServerImpl.class.getClassLoader().getResourceAsStream("MyBatis-Config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDao = sqlSession.getMapper(UserDAO.class);

        User user = userDao.getUser(id);

        sqlSession.close();
        HashMap<String, Object> map = new HashMap<>();
        if (user != null && id.equals(user.getId())) {
            map.put("user", user);
            return Result.SUCCESS("获取成功", map);
        }
        return Result.SUCCESS("获取失败", map);
    }

    @Override
    public Result deleteUser(String id) {
        InputStream inputStream = UserServerImpl.class.getClassLoader().getResourceAsStream("MyBatis-Config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDao = sqlSession.getMapper(UserDAO.class);

        userDao.deleteUser(id);

        sqlSession.commit();
        sqlSession.close();
        return Result.SUCCESS("删除成功", new HashMap<>());
    }

    @Override
    public Result updateUser(User user) {
        InputStream inputStream = UserServerImpl.class.getClassLoader().getResourceAsStream("MyBatis-Config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDao = sqlSession.getMapper(UserDAO.class);

        userDao.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
        return Result.SUCCESS("更新成功", new HashMap<>());
    }
}

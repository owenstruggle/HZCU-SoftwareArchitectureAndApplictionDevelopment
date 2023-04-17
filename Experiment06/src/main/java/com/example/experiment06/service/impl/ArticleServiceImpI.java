package com.example.experiment06.service.impl;

import com.example.experiment06.entity.Article;
import com.example.experiment06.repository.ArticleRepository;
import com.example.experiment06.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Owem
 * @date 2023/4/17 15:57
 * @description TODO
 **/
@Service
public class ArticleServiceImpI implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Description：重写service接口的实现，实现列表功能
     **/
    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    /**
     * Description:重写service接口的实现，实现根据id查询对象功能
     **/
    @Override
    public Article findArticleById(long id) {
        return articleRepository.findById(id);
    }
}

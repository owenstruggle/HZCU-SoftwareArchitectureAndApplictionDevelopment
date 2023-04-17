package com.example.experiment06.service;

import com.example.experiment06.entity.Article;

import java.util.List;

/**
 * @author Owem
 * @date 2023/4/17 15:56
 * @description TODO
 **/
public interface ArticleService {
    public List<Article> getArticleList();

    public Article findArticleById(long id);
}

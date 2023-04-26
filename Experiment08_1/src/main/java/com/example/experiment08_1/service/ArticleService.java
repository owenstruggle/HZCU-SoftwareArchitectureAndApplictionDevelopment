package com.example.experiment08_1.service;


import com.example.experiment08_1.entity.Article;

import java.util.List;

public interface ArticleService {
    public List<Article> getArticleList();

    public Article findArticleById(long id);

}

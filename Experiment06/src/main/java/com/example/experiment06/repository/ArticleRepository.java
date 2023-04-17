package com.example.experiment06.repository;

import com.example.experiment06.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Owem
 * @date 2023/4/17 15:54
 * @description TODO
 **/
public interface ArticleRepository extends JpaRepository<Article, Long>, JpaSpecificationExecutor<Article> {
    Article findById(long id);
}

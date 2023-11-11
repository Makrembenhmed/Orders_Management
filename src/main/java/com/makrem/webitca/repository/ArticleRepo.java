package com.makrem.webitca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.makrem.webitca.models.Article;

public interface ArticleRepo extends CrudRepository<Article, Long> {
List<Article> findAll();
}

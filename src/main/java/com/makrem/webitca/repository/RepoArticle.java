package com.makrem.webitca.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.makrem.webitca.models.Article;

public interface RepoArticle extends PagingAndSortingRepository<Article, Long> {

}

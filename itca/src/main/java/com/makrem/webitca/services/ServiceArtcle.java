package com.makrem.webitca.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.repository.RepoArticle;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceArtcle {
	@Autowired
	RepoArticle RepoArticle;
	// static variable to set the number of articles that we want per page
	private static final int PAGE_SIZE = 5;

	public Page<Article> articlesPerPage(int pageNumber) {
		// get all the articles page and sort them in ascending order the last name
		// property
		 PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE);
		Page<Article> articles = RepoArticle.findAll(pageRequest);
		return RepoArticle.findAll(pageRequest);
	}
}

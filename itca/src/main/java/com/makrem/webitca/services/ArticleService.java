package com.makrem.webitca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.repository.ArticleRepo;

@Service
public class ArticleService {
	
	
	// ----  crud ===
	
	
	@Autowired	
	private ArticleRepo articleRepository;
	
	// Read All
	public List<Article> allArticles() {
        return articleRepository.findAll();
    }

    // create
    public Article createArticle(Article a) {
        return articleRepository.save(a);
    }

    // retrieves a book   find by id // read one
    public Article findArticle(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if(optionalArticle.isPresent()) {
            return optionalArticle.get();
        } else {
            return null;
        } 
    }
    public void deleteArticle(Long id) {
    	articleRepository.deleteById(id);
    }
    public Article updateArticle(Article a) {
  		return articleRepository.save(a);
  	}





}

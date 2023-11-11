package com.makrem.webitca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.models.Picture;

@Repository
public interface PictureRepo extends CrudRepository<Picture, Long> {
	
	 List<Picture> findAllByArticle(Article article);
	
}

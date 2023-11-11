package com.makrem.webitca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.models.Picture;
import com.makrem.webitca.repository.PictureRepo;

@Service
public class PictureService {

	@Autowired
	private PictureRepo pRepo;
	
	// create image objet + save to data base 
	
	public void uploadPic(Article article , String url , String description) {
		
		Picture newPic = new Picture(url,description,article);
		this.pRepo.save(newPic);
	}
	
	public List<Picture> articlePictures(Article article){
		
		return this.pRepo.findAllByArticle(article);
	}
	
} 

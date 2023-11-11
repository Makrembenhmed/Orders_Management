package com.makrem.webitca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.services.ServiceArtcle;

@Controller
public class ArtControllerpage {
@Autowired

private ServiceArtcle serviceart;
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax
	    Page<Article> articles = serviceart.articlesPerPage(pageNumber-1);
	    // total number of pages that we have
	    int totalPages = articles.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("articles", articles);
	    return "articles.jsp";
	}
}

package com.makrem.webitca.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.models.Famillearticle;
import com.makrem.webitca.models.Picture;
import com.makrem.webitca.services.ArticleService;
import com.makrem.webitca.services.FamilleService;
import com.makrem.webitca.services.PictureService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleservice;
	@Autowired
	private FamilleService familleservice;
	@Autowired 
	private PictureService pserv;

	@GetMapping("/newarticle")
	public String AddArticle(@ModelAttribute("newArt") Article article, HttpSession s, Model model) {
		Long userid = (Long) s.getAttribute("user_id");
		List<Article> articles=articleservice.allArticles();
		if (userid == null) {
			return "redirect:/login";
		} else {

			List<Famillearticle> familles = familleservice.allFamilles();
			model.addAttribute("familles", familles);
			model.addAttribute("articles", articles);
			return "createarticle.jsp";
		}
	}

	@PostMapping("/newarticle")

	public String newArt(@Valid @ModelAttribute("newArt") Article newArt, BindingResult result, Model model,
			HttpSession s) 
			  {
		Long userid = (Long) s.getAttribute("user_id");
				
		if (userid == null) {
			return "redirect:/login";
		}

		if (result.hasErrors()) {
			List<Famillearticle> familles = familleservice.allFamilles();
			
			model.addAttribute("familles", familles);
			List<Article> articles=articleservice.allArticles();
			model.addAttribute("articles", articles);
			return "createarticle.jsp";
		} else {

			articleservice.createArticle(newArt);
			return "redirect:/newarticle";
		}
	}
	

	// rendre to edit page
	@GetMapping("/editarticle/{id}")
	public String editpage(@PathVariable("id") Long id, Model model) {
		// find book to edit
		Article thisArt = articleservice.findArticle(id);
		List<Famillearticle> familles = familleservice.allFamilles();
		
		model.addAttribute("familles", familles);
		
		// Pass the book to the jsp file to show
		model.addAttribute("article", thisArt);

		return "editarticle.jsp";

	}

// method for edit
	@PutMapping("/editarticle/{id}")
	public String update(@Valid @ModelAttribute("article") Article article, BindingResult result, HttpSession s, Model model) {
		if (result.hasErrors()) {
			List<Famillearticle> familles = familleservice.allFamilles();
			
			model.addAttribute("familles", familles);
			return "editarticle.jsp";
		} else {
			
		//	Article originalBook = articleservice.findArticle(article.getId());
			//book.setLibrary(originalBook.getLibrary());
			// grap the id curent user login
			//Long userid = (Long) s.getAttribute("user_id");
			//// grap the curent user login
			//User curentUser = userservice.findOne(userid);
			//book.setAuthor(curentUser);
			

			articleservice.updateArticle(article);
			
			return "redirect:/newarticle";
		}

	}

	@DeleteMapping("/article/{id}")
	public String deleteArticle(@PathVariable("id") Long id) {
		
		
				
		articleservice.deleteArticle(id);
		return "redirect:/newarticle";

	}

@GetMapping("/show/{id}")
public String showArticle(@PathVariable("id") Long id, Model model) {
	
	Article thisArt = articleservice.findArticle(id);
	List<Picture> pics=pserv.articlePictures(thisArt);
	model.addAttribute("pics", pics);
	model.addAttribute("thisart", thisArt);
	return "show.jsp";
}


	}


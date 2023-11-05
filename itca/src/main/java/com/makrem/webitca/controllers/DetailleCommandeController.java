package com.makrem.webitca.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.models.Client;
import com.makrem.webitca.models.Commande;
import com.makrem.webitca.models.LigneCommande;
import com.makrem.webitca.services.ArticleService;
import com.makrem.webitca.services.ClientService;
import com.makrem.webitca.services.CommandeService;
import com.makrem.webitca.services.LignecommandeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class DetailleCommandeController {

	@Autowired
	private CommandeService commandeService;

	@Autowired
	private LignecommandeService LignecommandeService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ClientService userService;

	@GetMapping("/newcmd")
	public String allarticles(Model model, HttpSession s) {
		// show all Articles
		List<Article> allarticles = articleService.allArticles();
		model.addAttribute("articles", allarticles);

		Long userID = (Long) s.getAttribute("user_id");
		// System.out.println(userID);
		if (userID == null) {
			return "redirect:/login";
		} else {
			Client potentielUser = userService.findOne(userID);
			model.addAttribute("name", potentielUser.getUserName());

			Commande newcmd = new Commande();
			newcmd.setAcheteur(potentielUser);
			Date date = new Date();
			newcmd.setDatecommande(date);
			newcmd.setDescription("Commande Urgente");
			Commande addcommande = commandeService.createCommande(newcmd);
			model.addAttribute("numcmd", addcommande.getId());

		List<LigneCommande > lignescommande = LignecommandeService.alllignecmde();
			 model.addAttribute("lignescmd", lignescommande);

			return "Lignecommande.jsp";
		}
	}

	@GetMapping("/commander/{numcmd}")
	public String newlignecmd(@PathVariable("numcmd") Long numcmd, HttpSession s,
			Model model) {

		// get All Articles
		List<Article> allarticles = articleService.allArticles();
		model.addAttribute("articles", allarticles);
		// User logged
		Long userID = (Long) s.getAttribute("user_id");
		Client potentielUser = userService.findOne(userID);
		model.addAttribute("name", potentielUser.getUserName());
		Commande curentcmd=commandeService.findCommande(numcmd);
		
		model.addAttribute("numcmd", curentcmd.getId());

	//	List<LigneCommande> lignescommande = LignecommandeService.alllignecmde();
		//model.addAttribute("lignescmd", lignescommande);
		
		Commande curentcm =commandeService.findCommande(numcmd);
		
		List <LigneCommande> lignecm = curentcm.getLignecommande();
		model.addAttribute("lignescmd", lignecm);

		return "Lignecommande.jsp";
	}

	@PostMapping("/commander/{id}/{numcmd}")
	public String newlignecmde(@Valid @PathVariable("id") Long id, @PathVariable("numcmd") Long numcmd,
			 HttpSession s, Model model) {

		//Long userID = (Long) s.getAttribute("user_id");
		//Client potentielUser = userService.findOne(userID);
		
		
		

		
		Article selectart = articleService.findArticle(id);
		
		Commande addcommande = commandeService.findCommande(numcmd);
		// new objet empty ligne cmde
		LigneCommande newlignecmd = new LigneCommande();

		// create new ligne commande
		newlignecmd.setArticle(selectart);
		newlignecmd.setCommande(addcommande);
		newlignecmd.setQuantity(1);
		LigneCommande lignecmd = LignecommandeService.createLignecmde(newlignecmd);
		
		List<LigneCommande> alllignecmde=LignecommandeService.alllignecmde();
		model.addAttribute("lignescmd", alllignecmde);
Commande curentcmd=commandeService.findCommande(numcmd);
		
		model.addAttribute("numcmd", curentcmd.getId());

		return "redirect:/commander/{numcmd}";
	}
	//
	
	@DeleteMapping("/commander/{id}/{numcmd}/delete")
	public String deletelignecmd(@PathVariable("id") Long idart, @PathVariable("numcmd") Long numcmd) {
		Commande curentcmd=commandeService.findCommande(numcmd);
		Article art = articleService.findArticle(idart);
		List <LigneCommande> lignecmd = curentcmd.getLignecommande();
		
		for (int i = 0; i < lignecmd.size(); i++) {
		LigneCommande l=	LignecommandeService.lignecmdasupp(art, lignecmd.get(i));
		
		if (l!= null) {
			
			Long idligne=l.getId();
			LignecommandeService.deleteCommande(idligne);
			return "redirect:/commander/{numcmd}";
		}
		    }
		
		
		return "redirect:/commander/{numcmd}";

	}
	
}

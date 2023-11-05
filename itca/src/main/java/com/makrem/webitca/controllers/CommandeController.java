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


import com.makrem.webitca.models.Client;
import com.makrem.webitca.models.Commande;
import com.makrem.webitca.services.ClientService;
import com.makrem.webitca.services.CommandeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class CommandeController {
	
	@Autowired
	private CommandeService commandeservice;
	
	@Autowired
	private ClientService userservice;
	
	@GetMapping("/newcommande")
	public String addCommande( HttpSession s,@ModelAttribute("newcmd") Commande newcmd,Model model) {
		Long userid = (Long)s.getAttribute("user_id");
		if (userid== null) {
			return "redirect:/login";
		}else {
		s.getAttribute("user_name");
		List<Commande> listcmd=commandeservice.allCommandes();
		model.addAttribute("commandes", listcmd);
		Client user=userservice.findOne(userid);
		model.addAttribute("client", user);
		
		return "commande.jsp";}
	}
@PostMapping("/newcommande")

public String newcommande(@Valid @ModelAttribute("newcmd") Commande newcmd , BindingResult result,  Model model, HttpSession s) 
{
	Long userid = (Long)s.getAttribute("user_id");
	if (userid== null) {
		return "redirect:/login";
	}else {
	
	
	if (result.hasErrors()) {
		List<Commande> listcmd = commandeservice.allCommandes();
		model.addAttribute("commandes", listcmd);
		return "commande.jsp";
	} else {
		// grap the id curent user login
	
		// grap the curent user login
		Client curentUser = userservice.findOne(userid);
		s.getAttribute("user_name");
		newcmd.setAcheteur(curentUser);
		 commandeservice.createCommande(newcmd);
		return "redirect:/newcommande";
	}
	}

	
}


// rendre to edit page
@GetMapping("/edit/{id}")
public String editpage(@PathVariable("id") Long id,@ModelAttribute("cmd") Commande commande, Model model, HttpSession s) {
	Long userid = (Long)s.getAttribute("user_id");
	if (userid== null ) {
		return "redirect:/login";
	}else {
	
	
	// find book to edit
	Commande thisCommande = commandeservice.findCommande(id);
	
	if (thisCommande == null) {
		return "redirect:/login";
	}
	
	if (thisCommande.getAcheteur().getId()!=userid ){
		return "redirect:/login";
		
	}
	// Pass the book to the jsp file to show
	model.addAttribute("cmd", thisCommande);

	return "edit.jsp";
	}
}

//method for edit
@PutMapping("/edit/{id}")
public String update(@Valid @ModelAttribute("cmd") Commande cmd, BindingResult result, HttpSession s) {
	
	Long userid = (Long)s.getAttribute("user_id");
	if (userid== null) {
		return "redirect:/login";
	}else {
	
	
	if (result.hasErrors()) {
		return "edit.jsp";
	} else {
		
		Commande originalCommande = commandeservice.findCommande(cmd.getId());
		
		// grap the id curent user login
		
		// grap the curent user login
		Client curentUser = userservice.findOne(userid);
		cmd.setAcheteur(curentUser);

		commandeservice.updateProject(cmd);
		return "redirect:/newcommande";
	}
	}
	
	}

@DeleteMapping("/delete/{id}")
public String deletecommande(@PathVariable("id") Long id, HttpSession s) {
	Long userid = (Long)s.getAttribute("user_id");
	if (userid== null) {
		return "redirect:/login";
	}else {
	
	
commandeservice.deleteCommande(id);
	return "redirect:/newcommande";
	}
}


@GetMapping("/commande/show/{id}")
public String showcommande(@PathVariable("id") Long idcmd, Model model, HttpSession s) {
	
	Long userid = (Long)s.getAttribute("user_id");
	if (userid== null) {
		return "redirect:/login";
	}else {
	
	
	Commande thiscmd=commandeservice.findCommande(idcmd);
	model.addAttribute("thiscmd", thiscmd);
	return "show.jsp";
}
}

}

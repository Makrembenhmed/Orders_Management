package com.makrem.webitca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.makrem.webitca.models.Famillearticle;
import com.makrem.webitca.services.FamilleService;

import jakarta.validation.Valid;

@Controller
public class FamilleController {
@Autowired
private FamilleService familleService;

	
	// Read All
	
	@GetMapping("/newfamille")
	public String Famille(@ModelAttribute("famille") Famillearticle Fam, Model model) {
		List<Famillearticle> listFam=familleService.allFamilles();
		model.addAttribute("listFam", listFam);
		return "familleart.jsp";
	}
	
	@PostMapping("/newfamille")
	
	public String createLib(@Valid @ModelAttribute("famille") Famillearticle Fam, BindingResult result , Model model) {
		if (result.hasErrors()) {
			List<Famillearticle> listFam=familleService.allFamilles();
			model.addAttribute("listFam", listFam);
			return "familleart.jsp";
		}else {familleService.createFamille(Fam);
		return "redirect:/newfamille";}
		
	}
}

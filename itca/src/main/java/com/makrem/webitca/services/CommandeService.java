package com.makrem.webitca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makrem.webitca.models.Commande;
import com.makrem.webitca.repository.CommandeRepo;

@Service
public class CommandeService {
	
	// ----  crud ===
	
	
	@Autowired	
	private CommandeRepo commandeRepository;
	
	// Read All
	public List<Commande> allCommandes() {
        return commandeRepository.findAll();
    }

    // create
    public Commande createCommande(Commande c) {
        return commandeRepository.save(c);
    }

    // retrieves a book   find by id // read one
    public Commande findCommande(Long id) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        if(optionalCommande.isPresent()) {
            return optionalCommande.get();
        } else {
            return null;
        } 
    }
    public void deleteCommande(Long id) {
    	commandeRepository.deleteById(id);
    }
    public Commande updateProject(Commande c) {
  		return commandeRepository.save(c);
  	}



}

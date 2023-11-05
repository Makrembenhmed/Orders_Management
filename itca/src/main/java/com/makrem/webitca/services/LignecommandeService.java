package com.makrem.webitca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.models.LigneCommande;
import com.makrem.webitca.repository.LignecommandeRepo;

@Service
public class LignecommandeService {
	
	// ----  crud ===
	
	
	@Autowired	
	private LignecommandeRepo LignecommandeRepo;
	
	// Read All
	

	public List<LigneCommande> alllignecmde() {
        return LignecommandeRepo.findAll();
	
    }

    // create
    public LigneCommande createLignecmde(LigneCommande c) {
        return LignecommandeRepo.save(c);
    }

    // retrieves a book   find by id // read one
    public LigneCommande findCommande(Long id) {
        Optional<LigneCommande> optionalCommande = LignecommandeRepo.findById(id);
        if(optionalCommande.isPresent()) {
            return optionalCommande.get();
        } else {
            return null;
        } 
    }
    public void deleteCommande(Long id) {
    	LignecommandeRepo.deleteById(id);
    }
    public LigneCommande updateProject(LigneCommande c) {
  		return LignecommandeRepo.save(c);
  	}

public LigneCommande lignecmdasupp (Article art ,LigneCommande c  ) {
	
	if( c.getArticle()==art) {
		return c;
	}else {
		return null;	
	}
	
	
}

}

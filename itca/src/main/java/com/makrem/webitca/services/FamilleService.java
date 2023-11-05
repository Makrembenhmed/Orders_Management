package com.makrem.webitca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makrem.webitca.models.Famillearticle;
import com.makrem.webitca.repository.FamilleRepo;

@Service
public class FamilleService {
	
	
	// ----  crud ===
	
	
	@Autowired	
	private FamilleRepo familleRepository;
	
	// Read All
	public List<Famillearticle> allFamilles() {
        return familleRepository.findAll();
    }

    // create
    public Famillearticle createFamille(Famillearticle a) {
        return familleRepository.save(a);
    }

    // retrieves a book   find by id // read one
    public Famillearticle findFamille(Long id) {
        Optional<Famillearticle> optionalArticle = familleRepository.findById(id);
        if(optionalArticle.isPresent()) {
            return optionalArticle.get();
        } else {
            return null;
        } 
    }
    public void deleteArticle(Long id) {
    	familleRepository.deleteById(id);
    }
    public Famillearticle updateArticle(Famillearticle a) {
  		return familleRepository.save(a);
  	}





}

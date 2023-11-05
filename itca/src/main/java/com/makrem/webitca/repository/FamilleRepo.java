package com.makrem.webitca.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.makrem.webitca.models.Famillearticle;

public interface FamilleRepo extends CrudRepository<Famillearticle, Long> {
	
	List<Famillearticle> findAll();
    // get all the names of the familles
    //@Query("SELECT f.name FROM Famillearticle f")
    //List<String> findAllFamillesNames();
    
    // passing params and filtering (still retrieves a list)
    //@Query("SELECT f FROM Famillearticle d WHERE id = ?1")
    //List<Famillearticle> getFamillearticleWhereId(Long id);
}

package com.makrem.webitca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.makrem.webitca.models.LigneCommande;

public interface LignecommandeRepo extends CrudRepository<LigneCommande, Long> {
	List<LigneCommande> findAll();

}

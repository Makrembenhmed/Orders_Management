package com.makrem.webitca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.makrem.webitca.models.Commande;

public interface CommandeRepo extends CrudRepository<Commande, Long> {
	List<Commande> findAll();

}

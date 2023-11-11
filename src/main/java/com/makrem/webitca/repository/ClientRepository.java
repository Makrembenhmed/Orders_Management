package com.makrem.webitca.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.makrem.webitca.models.Client;





public interface ClientRepository extends CrudRepository<Client, Long> {
	 
	Optional <Client> findByEmail(String email);
}

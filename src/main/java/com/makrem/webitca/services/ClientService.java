package com.makrem.webitca.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.makrem.webitca.models.Client;
import com.makrem.webitca.models.LoginUser;
import com.makrem.webitca.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepo;
    
    // TO-DO: Write register and login methods!
    public Client register(Client newUser, BindingResult result) {
    	
        // reject if email is taken ( present in db)
    	
    	Optional <Client> potentielUser=clientRepo.findByEmail(newUser.getEmail());
    	if(potentielUser.isPresent()) {
    		result.rejectValue("email", "registerError", "email is taken");
    		   	
    	}
    	if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("password", "registerError", "password does not match");
    	}
    	if (result.hasErrors()) {
    		return null;
     	}else {
    		//hash and send password 
    		String hashed=BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		//save the User
    		
    		return clientRepo.save(newUser);  
    	}
        
    }
    	
    
    

    public Client login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	Optional <Client> PotentielUser= clientRepo.findByEmail(newLoginObject.getEmail());
    	if (!PotentielUser.isPresent()) {
    		result.rejectValue("email", "LoginError", "email Not Found");
    		
    	}else { Client user=PotentielUser.get();
    	 
    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		    result.rejectValue("password", "LoginError", "Invalid Password!");
    		}
    		if (result.hasErrors()) {
    			return null;
    		}else {return user;}
    		}
    	return null;
    	}
    	

 // Update 
 public Client updateuser(Client u) {
 	
 	return clientRepo.save(u);
 }

 // read one 
        
 public Client findOne(Long id) {
     Optional<Client> optionalUser = clientRepo.findById(id);
     if(optionalUser.isPresent()) {
         return optionalUser.get();
     } else {
         return null;
     }
 }
 
}
    
    
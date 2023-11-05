package com.makrem.webitca.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.makrem.webitca.models.Client;
import com.makrem.webitca.models.LoginUser;
import com.makrem.webitca.services.ClientService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	@Autowired
	private ClientService userserv;
	@GetMapping("/")
	public String HomeLogin()
	{
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginForm(@ModelAttribute("newUser") Client newUser,
							@ModelAttribute("newLogin") LoginUser newLogin, 
							Model model) {
		model.addAttribute("newUser", new Client());
		model.addAttribute("newLogin", new LoginUser());

		return "auth.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") Client newUser, BindingResult result, Model model,
			HttpSession session) {
		userserv.register(newUser, result);	
			
		// TO-DO Later -- call a register method in the service
		// to do some extra validations and create a new user!

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "auth.jsp";
		}

		// No errors!
		// TO-DO Later: Store their ID from the DB in session,
		// in other words, log them in.
			session.setAttribute("user_id", newUser.getId());
			session.setAttribute("user_name", newUser.getUserName());
		return "redirect:/dashboard";
	}
	
	
	// Login 
	//Action route
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
         
        // Add once service is implemented:
         Client user = userserv.login(newLogin, result);
		
        if(result.hasErrors()) {
            model.addAttribute("newUser", new Client());
            return "auth.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        session.setAttribute("user_name", user.getUserName());
		return "redirect:/dashboard";
        
    }
    
	@GetMapping("/dashboard")
	public String dashboard () {
		return "dashboard.jsp";
	}
	// render route
//@GetMapping("/books")
//public String Succ(HttpSession s , Model model) {	
	//System.out.println(s.getAttribute("user_id"));
	//Long userID = (Long) s.getAttribute("user_id");
	//System.out.println(userID);
	//if (userID == null) {
	//return "redirect:/index";
	//}else {
	 //User potentielUser = userserv.findOne(userID); 
	//model.addAttribute("name", potentielUser.getUserName());
	//return "books.jsp";
//	}
	
	
	
//}

	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/login";
	}	
}
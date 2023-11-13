package com.makrem.webitca.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.makrem.webitca.models.Article;
import com.makrem.webitca.services.ArticleService;
import com.makrem.webitca.services.ClientService;
import com.makrem.webitca.services.PictureService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/picture")
public class PictureController {
	@Autowired
	private ArticleService aServ;
	@Autowired
	private PictureService pServ;
	@Autowired
	private ClientService uServ;
	
	private static String UPLOAD_FOLDER="src/main/resources/static/img/";

	@GetMapping("/add/{id}")
	public String Addpicture(@PathVariable("id") Long id , Model model, HttpSession s) {
		model.addAttribute("curentArt",this.aServ.findArticle(id));
		model.addAttribute("curentUser",this.uServ.findOne((Long)s.getAttribute("user_id")));
		
		return "picture.jsp";
		
	}
	@PostMapping("/upload/{id}")
	public String Upload(@RequestParam("pic") MultipartFile file,
						@RequestParam("description") String desc, @PathVariable("id") Long id,
						HttpSession s, RedirectAttributes redirectatt ) {
		Article curentart=aServ.findArticle(id);
		// save the Uploaded file in the static folder
		if (file.isEmpty()) {
			redirectatt.addFlashAttribute("message",  " please upload your picture for Item  can not be empty!!!");
			return "redirect:/picture/add/{id}";
		}
		try {
			//get the file throw it into the server folder
			byte [] bytes=file.getBytes();
			Path path=Paths.get(UPLOAD_FOLDER +file.getOriginalFilename());
			Files.write(path, bytes);
			// get url of the file we just uploaded 
			String url="/img/"+file.getOriginalFilename();
			if (desc.isEmpty()) {
				redirectatt.addFlashAttribute("message1",  " please the description must be not empty!!!");
				return "redirect:/picture/add/{id}";
				
			}
			this.pServ.uploadPic(curentart, url, desc);
		}catch(IOException e){
			e.printStackTrace();
		}
		return "redirect:/picture/add/{id}";
		
		
	}
}

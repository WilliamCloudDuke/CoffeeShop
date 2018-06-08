package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService pService;

	@GetMapping({ "/" })
	public String homePage(Model model) {
		System.out.println("going home");
		model.addAttribute("products", pService.findAll());
		return "index";
	}

	@GetMapping({ "/login" })
	public String securePage() {
		System.out.println("going to login");
		return "login";
	}

}

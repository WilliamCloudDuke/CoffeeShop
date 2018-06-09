package edu.mum.coffee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private PersonService personService;

	@GetMapping({ "/" })
	public String homePage(Model model) {
		System.out.println("going home");
		model.addAttribute("products", productService.findAll());
		return "index";
	}

	@GetMapping({ "/login" })
	public String securePage() {
		System.out.println("going to login");
		return "login";
	}

	@RequestMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	}

	@GetMapping("shopping-cart")
	public String shoppingCart(Model model, HttpSession session) {
		Object orderO = session.getAttribute("orderCart");
		double total = 0;
		if (null != orderO) {
			Order order = (Order) orderO;
			model.addAttribute("order", order);
			for (Orderline ol : order.getOrderLines()) {
				total += ol.getSubtotal();
			}
		}
		model.addAttribute("total", total);
		return "shoppingCart";
	}

	@GetMapping("/signup")
	public String signupPage(Model model) {
		model.addAttribute("person", new Person());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute Person person) {
		personService.singup(person);
		return "redirect:/login";
	}

}

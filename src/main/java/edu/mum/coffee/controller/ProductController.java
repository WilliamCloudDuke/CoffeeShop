package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService pService;

	@GetMapping("/products")
	public String productList(Model model) {
		model.addAttribute("products", pService.getAllProduct());
		return "productList";
	}

	@GetMapping("/products/{id}")
	public String productById(@PathVariable("productId") int id, Model model) {
		model.addAttribute("product", pService.getProduct(id));
		return "productDetail";
	}

	@PostMapping("/product")
	public String createProduct(@ModelAttribute Product product) {
		pService.save(product);
		return "redirect:/products";
	}

	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable("productId") int id) {
		pService.deleteById(id);
		return "redirect:/products";
	}

	@PutMapping("/product/{id}")
	public String updateProduct(@PathVariable("productId") int id, @ModelAttribute Product product) {
		pService.save(product);
		return "redirect:/products";
	}

}

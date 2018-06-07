package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService oService;

	@GetMapping("/orders")
	public String orderList(Model model) {
		model.addAttribute("orders", oService.findAll());
		return "orderList";
	}

	@PostMapping("/order")
	public String createOrder(@ModelAttribute Order order) {
		oService.save(order);
		return "redirec:/orders";
	}

	@PutMapping("/order/{id}")
	public String updateOrder(@PathVariable("orderId") int id, @ModelAttribute Order order) {
		oService.save(order);
		return "redirect:/orders";
	}

}

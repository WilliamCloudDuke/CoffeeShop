package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import edu.mum.coffee.config.UserConfigAdapter;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@Controller
public class OrderController {

	@Autowired
	private OrderService oService;

	@Autowired
	private PersonService pService;

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

	@PostMapping("/createOrder")
	public String createOrder(HttpSession session, Authentication auth) {
		Object oObj = session.getAttribute("orderCart");
		if (null == oObj) {
			oObj = new Order();
			session.setAttribute("orderCart", oObj);
		}
		Order order = (Order) oObj;
		order.setOrderDate(new Date());
		UserConfigAdapter userAdapter = (UserConfigAdapter) auth.getPrincipal();
		List<Person> persons = pService.findByEmail(userAdapter.getUser().getEmail());
		order.setPerson(persons.get(0));
		oService.save(order);
		session.removeAttribute("orderCart");
		return "redirect:/";
	}

}

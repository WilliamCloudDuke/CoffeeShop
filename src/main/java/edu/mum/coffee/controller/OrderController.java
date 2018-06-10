package edu.mum.coffee.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

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
	private OrderService orderService;

	@Autowired
	private PersonService personService;

	@GetMapping("/orders")
	public String orderList(Model model) {
		model.addAttribute("orders", orderService.findAll());
		return "orderList";
	}

	@PostMapping("/order")
	public String createOrder(@ModelAttribute Order order) {
		orderService.save(order);
		return "redirec:/orders";
	}

	@PutMapping("/order/{id}")
	public String updateOrder(@PathVariable("orderId") int id, @ModelAttribute Order order) {
		orderService.save(order);
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
		List<Person> persons = personService.findByEmail(userAdapter.getUser().getEmail());
		Person person = persons.get(0);
		order.setPerson(person);
		orderService.save(order);
		session.removeAttribute("orderCart");
		return "redirect:/";
	}

	@GetMapping("/order/{orderId}")
	public String orderDetail(@PathParam("orderId") int id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "order";
	}

	@GetMapping("/order")
	public String setOrder(Model model) {
		model.addAttribute("order", new Order());
		return "order";
	}

}

package edu.mum.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.coffee.config.UserConfigAdapter;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private OrderService orderService;

	@GetMapping("/persons")
	public String personList(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "personList";
	}

	@GetMapping("/person")
	public String setPerson(Model model) {
		model.addAttribute("person", new Person());
		return "personDetail";
	}

	@PostMapping("/person")
	public String createPerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/persons";
	}

	@DeleteMapping("/person")
	public String deletePerson(@ModelAttribute Person person) {
		personService.removePerson(person);
		return "redirect:/persons";
	}

	@GetMapping("/persons/{id}")
	public String personDetail(@PathVariable("personId") Long id, Model model) {
		model.addAttribute(personService.findById(id));
		return "personDetail";
	}

	@GetMapping("/my-account")
	public String myProfile(Model model, Authentication authentication) {
		UserConfigAdapter userConfig = (UserConfigAdapter) authentication.getPrincipal();
		List<Person> persons = getListPersons(userConfig.getUser().getEmail());
		model.addAttribute("person", persons.get(0));
		model.addAttribute("orders", getListOrders(persons.get(0)));
		return "myAccount";
	}

	public List<Person> getListPersons(String email) {
		return personService.findByEmail(email);
	}

	public List<Order> getListOrders(Person person) {
		return orderService.findByPerson(person);
	}

	@PostMapping("/my-account")
	public String updateAccount(@ModelAttribute("person") Person person, final RedirectAttributes redirectAttributes) {
		System.out.println("POST -  updateAccount");
		personService.savePerson(person);
		redirectAttributes.addFlashAttribute("message", "Successfully updated");
		return "redirect:/my-account";
	}

}

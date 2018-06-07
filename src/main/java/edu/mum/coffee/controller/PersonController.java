package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService pService;

	@GetMapping("/persons")
	public String personList(Model model) {
		model.addAttribute("persons", pService.findAll());
		return "personList";
	}

	@PostMapping("/person")
	public String createPerson(@ModelAttribute Person person) {
		pService.savePerson(person);
		return "redirect:/persons";
	}

	@GetMapping("/persons/{id}")
	public String personById(@PathVariable("personId") Long id) {
		pService.findById(id);
		return "personDetail";
	}

}

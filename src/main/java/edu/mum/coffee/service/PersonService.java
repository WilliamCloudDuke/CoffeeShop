package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Role;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.PersonRepository;
import edu.mum.coffee.repository.RoleRepository;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	private Role getRole() {
		return roleRepository.findByRole("ROLE_CUSTOMER");
	}

	public void singup(Person person) {
		person.setEnabled(true);
		User user = new User();
		user.setEmail(person.getEmail());
		user.setEnabled(person.isEnabled());
		user.addRole(getRole());// CUSTOMER ROLE
		user.setPassword(passwordEncoder.encode(person.getPassword()));
		System.out.println("user.getPassword: " + user.getPassword());
		// PERSON RECORD
		person = personRepository.save(person);
		// USER RECORD
		userRepository.save(user);
	}

	public Person savePerson(Person person, User user) {
		return personRepository.save(person);
	}

	public Person savePerson(Person person) {
		if (null != person) {
			User user = userRepository.findByEmail(person.getEmail());
			if (null != user) {
				user.setEnabled(person.isEnabled());
				userRepository.save(user);
			} else {
				System.out.println("USER is NULL");
			}
			return personRepository.save(person);
		} else {
			return new Person();
		}
	}

	// public List<Person> findByFirstName() {
	// return personRepository.findByFirstName();
	// }

}

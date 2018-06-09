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

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> findByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	public Person findById(Long id) {
		return personRepository.findOne(id);
	}

	public void removePerson(Person person) {
		personRepository.delete(person);
	}

	public void singup(Person person) {
		person.setEnable(true);
		User user = new User();
		user.setEmail(person.getEmail());
		user.setEnabled(person.isEnable());
		user.addRole(getRole());
		user.setPassword(passwordEncoder.encode(person.getPassword()));
		person = personRepository.save(person);
		userRepository.save(user);
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	private Role getRole() {
		return roleRepository.findByRole("ROLE_CUSTOMER");
	}

	// public List<Person> findByFirstName() {
	// return personRepository.findByFirstName();
	// }

}

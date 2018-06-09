package edu.mum.coffee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.mum.coffee.config.UserConfigAdapter;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PersonService personService;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(userEmail);
		if (null == user) {
			throw new UsernameNotFoundException("User " + userEmail + "does not exist");
		}
		List<Person> persons = personService.findByEmail(userEmail);
		Person p = persons.get(0);
		return new UserConfigAdapter(user, p);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findByEnabled(boolean enabled) {
		return userRepository.findByEnabled(enabled);
	}

}

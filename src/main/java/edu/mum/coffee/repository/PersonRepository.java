package edu.mum.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByEmail(String email);

	public List<Person> findAll();
	//
	// public List<Person> findByFirstName();
}

package edu.mum.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.User;

@Repository
public abstract interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	List<User> findByEnabled(boolean enabled);

	List<User> findAll();

}

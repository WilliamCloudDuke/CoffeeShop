package edu.mum.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.coffee.domain.Role;

@Repository
public abstract interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);

	List<Role> findAll();
}

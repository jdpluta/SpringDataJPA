package com.jdp.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jdp.springdatajpa.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}

package com.jdp.springdatajpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdp.springdatajpa.entity.Role;
import com.jdp.springdatajpa.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired 
	RoleRepository roleRepository;
	
	public List<Role> getRoles() {
		List<Role> r = roleRepository.findAll();
		return r;
	}
}

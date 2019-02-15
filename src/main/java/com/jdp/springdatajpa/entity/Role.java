package com.jdp.springdatajpa.entity;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	private String role;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
	joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id") }, 
	inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private Collection<User> userList = new LinkedList<User>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		System.out.println("Role. getId. id + " + id + " list = " + userList);
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		System.out.println("Role. setRole. role + " + role + " list = " + userList);
		this.role = role;
	}

	public Collection<User> getUserList() {
		System.out.println("Role. getUserList. list = " + userList);
		return userList;
	}

	public void setUserList(List<User> userList) {
		System.out.println("Role. setUserList. list = " + userList);
		this.userList = userList;
	}
}

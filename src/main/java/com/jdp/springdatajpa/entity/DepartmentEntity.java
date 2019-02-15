package com.jdp.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class DepartmentEntity {
	@Id
//	@GeneratedValue//(strategy=GenerationType.AUTO)
	@Column(name="department_id")
	int department_id;
	@Column(name="name")
	String name;
	public DepartmentEntity() {
		super();
	}
	public DepartmentEntity(int department_id, String name) {
		super();
		this.department_id = department_id;
		this.name = name;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

package com.jdp.springdatajpa.model;

import java.util.Objects;

public class Department {
	int department_id;
	String name;
	public Department() {
		super();
	}
	public Department(int department_id, String name) {
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
	@Override
	public String toString() {
		return "Department:: id=" + department_id + " name=" + name;
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(department_id);
	}
//	@Override
	public boolean equals(Department dept) {
		if (dept == null || this.getClass() != dept.getClass() || this.department_id != dept.getDepartment_id())
			return false;
		return true;
	}
}

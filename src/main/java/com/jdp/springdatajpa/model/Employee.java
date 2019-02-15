package com.jdp.springdatajpa.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import com.jdp.springdatajpa.entity.DepartmentEntity;
import com.jdp.springdatajpa.entity.EmployeeEntity;

public class Employee {
	int employee_id;
	String name;
	String email;
	List<Department> departments;
	
	public Employee() {
		super();
	}
	public Employee(EmployeeEntity empEnt) {
		this(empEnt.getEmployee_id(), empEnt.getName(), empEnt.getEmail());
		this.departments = new LinkedList<Department>();
		empEnt.getDepartment().forEach(dept -> departments.add(new Department(dept.getDepartment_id(), dept.getName())));
	}

	public Employee(int employee_id, String name, String email) {
		super();
		this.employee_id = employee_id;
		this.name = name;
		this.email = email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public List<Department> getDepartment() {
		return departments;
	}

	public void setDepartment(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("Employee:: id=").append(employee_id).append(" name=").append(name).append(" email=").append(email);
		this.departments.forEach(dept -> strBuff.append(" ").append(dept));
		return  strBuff.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hashCode(employee_id);
	}
//	@Override
	public boolean equals(Employee emp) {
		if (emp == null || this.getClass() != emp.getClass() || this.employee_id != emp.getEmployee_id())
			return false;
		return true;
	}
}

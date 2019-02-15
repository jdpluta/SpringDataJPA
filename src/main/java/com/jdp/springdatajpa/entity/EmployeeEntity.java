package com.jdp.springdatajpa.entity;

import java.util.Collection;
import java.util.LinkedList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.jdp.springdatajpa.model.Employee;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue //(strategy=GenerationType.IDENTITY)
	@Column(name = "employee_id")
	int employee_id;
	@Column(name = "name")
	String name;
	@Column(name = "email")
	String email;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "employee_department", 
	joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id") }, 
	inverseJoinColumns = {@JoinColumn(name = "department_id", referencedColumnName = "department_id") })
//  @JoinTable(name="employee_department")
	private Collection<DepartmentEntity> departmentEntities = new LinkedList<DepartmentEntity>();

	public void setDepartment(Collection<DepartmentEntity> departments) {
		this.departmentEntities = departments;
	}

	public Collection<DepartmentEntity> getDepartment() {
		return departmentEntities;
	}

	public EmployeeEntity() {
		super();
	}

	public EmployeeEntity(Employee emp) {
		this(emp.getEmployee_id(), emp.getName(), emp.getEmail());
		this.departmentEntities = new LinkedList<>();
		emp.getDepartment().forEach(dept -> departmentEntities.add(new DepartmentEntity(dept.getDepartment_id(), dept.getName())));
	}
	public EmployeeEntity(int employee_id, String name, String email) {
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
}

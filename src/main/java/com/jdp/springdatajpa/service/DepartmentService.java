package com.jdp.springdatajpa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdp.springdatajpa.entity.DepartmentEntity;
import com.jdp.springdatajpa.entity.EmployeeEntity;
import com.jdp.springdatajpa.model.Department;
import com.jdp.springdatajpa.model.Employee;
import com.jdp.springdatajpa.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments() {
		List<DepartmentEntity> 	departmentEntities = departmentRepository.findAll();
		List<Department> departments = new ArrayList<Department>();
		departmentEntities.forEach(depEnt -> createEmployee(depEnt, departments));
		return departments;
	}
	
	private void createEmployee(DepartmentEntity depEnt, List<Department>employees) {
		Department employee = new Department(depEnt.getDepartment_id(), depEnt.getName());
		employees.add(employee);
	}

}

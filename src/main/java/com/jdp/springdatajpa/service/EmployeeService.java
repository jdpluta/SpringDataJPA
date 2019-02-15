package com.jdp.springdatajpa.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdp.springdatajpa.entity.DepartmentEntity;
import com.jdp.springdatajpa.entity.EmployeeEntity;
import com.jdp.springdatajpa.model.Department;
import com.jdp.springdatajpa.model.Employee;
import com.jdp.springdatajpa.repository.DepartmentRepository;
import com.jdp.springdatajpa.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	public Employee getEmployeeById(int id) {
		Employee employee = null;
		Optional<EmployeeEntity> optEmpEnt = employeeRepository.findById(id);
		if (optEmpEnt.isPresent()) {
			EmployeeEntity empEnt = optEmpEnt.get();
			employee = new Employee(empEnt);
		}
		return employee;
	}

	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		employeeEntities.forEach(empEnt -> createEmployee(empEnt, employees));
		return employees;
	}

	public Employee addEmployee(Employee newEmployee) {
		EmployeeEntity empEnt = new EmployeeEntity(newEmployee);
		empEnt.setDepartment(new LinkedList<DepartmentEntity>());
		for (Department dept : newEmployee.getDepartment()) {
			DepartmentEntity deptEnt = departmentRepository.getOne(dept.getDepartment_id());
			empEnt.getDepartment().add(deptEnt);
		}
		EmployeeEntity updEmpEnt = employeeRepository.save(empEnt);
		Employee employee = new Employee(updEmpEnt);
		return employee;
	}

	public Employee updateEmployee(Employee newEmployee) {
		EmployeeEntity empEnt = new EmployeeEntity(newEmployee);
		EmployeeEntity updEmpEnt = employeeRepository.save(empEnt);
		Employee employee = new Employee(updEmpEnt);
		return employee;
	}

	public void deleteEmployee(Employee emp) {
		EmployeeEntity empEnt = new EmployeeEntity(emp);
		employeeRepository.delete(empEnt);
	}

	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

	private void createEmployee(EmployeeEntity empEnt, List<Employee> employees) {
		Employee employee = new Employee(empEnt);
		employees.add(employee);
	}

//	private void createDepartments(DepartmentEntity depEnt, List<Department> departments) {
//		Department department = new Department(depEnt.getDepartment_id(), depEnt.getName());
//		departments.add(department);
//	}
}
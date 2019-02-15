package com.jdp.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.jdp.springdatajpa.entity.Role;
import com.jdp.springdatajpa.entity.User;
import com.jdp.springdatajpa.model.Department;
import com.jdp.springdatajpa.model.Employee;
import com.jdp.springdatajpa.service.DepartmentService;
import com.jdp.springdatajpa.service.EmployeeService;
import com.jdp.springdatajpa.service.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class SpringDataJpaApplicationTests {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	RoleService roleService;

	// @Test
	public void contextLoads() {}

//	@Test
	public void testFindEmployeeById() {
		int id = 2;
		testFindEmployeeById(id);
	}
	private void testFindEmployeeById(int id) {
		System.out.println("testFindEmployeeById. Id=" + id);
		Employee employee = employeeService.getEmployeeById(id);
//		Optional<Employee> actual = Optional.ofNullable(employee);
////		assertThat(actual).isNotNull();
//		assertThat(actual).isNotEmpty();
//		actual.get().setDepartment(null);
//		assertThat(actual.get().getDepartment()).isNotEmpty();
		assertThat(employee).isNotNull();
		assertThat(employee.getDepartment()).isNotNull();
		System.out.println(employee);
/*
		Collection<Department> ul = employee.getDepartment();
		if (ul == null || ul.isEmpty()) {
			System.out.println("testFindAllEmployees. Department = NULL");
		}
		else if (ul.isEmpty()) {
			System.out.println("testFindAllEmployees. Department = EMPTY");
		}
		else {
			System.out.println("testFindAllEmployees. Department = List");
			for (Department u : ul) {
				System.out.println(u);
			}
		}
*/		
	}

//	@Test
	public void testFindAllRoles() {
		List<Role> roles = roleService.getRoles();
		Optional<List<Role>> actual = Optional.of(roles);
		assertThat(actual).isNotNull();
//		roles.forEach(r -> {System.out.println(r); 
//												r.getUserList().forEach(u -> System.out.println(u))};
//									);
		System.out.println("testFindAllRoles. roles");
		for (Role r : roles) {
			System.out.println(r);
			System.out.println("testFindAllRoles. User");
			Collection<User> ul = r.getUserList();
			if (ul == null || ul.isEmpty()) {
				System.out.println("testFindAllRoles. User = NULL");
			}
			else if (ul.isEmpty()) {
				System.out.println("testFindAllRoles. User = EMPTY");
			}
			else {
				System.out.println("testFindAllRoles. User = List");
				for (User u : ul) {
					System.out.println(u);
				}
			}
		}
	}

//	@Test
	public void testFindAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		Optional<List<Employee>> actual = Optional.of(employees);
		assertThat(actual).isNotNull();
//		employees.forEach(emp -> System.out.println(emp));
		System.out.println("testFindAllEmployees. employees");
		for (Employee r : employees) {
			System.out.println(r);
			System.out.println("testFindAllEmployees. Employee");
			Collection<Department> ul = r.getDepartment();
			if (ul == null || ul.isEmpty()) {
				System.out.println("testFindAllEmployees. Department = NULL");
			}
			else if (ul.isEmpty()) {
				System.out.println("testFindAllEmployees. Department = EMPTY");
			}
			else {
				System.out.println("testFindAllEmployees. Department = List");
				for (Department u : ul) {
					System.out.println(u);
				}
			}
		}
//		Assert.assertFalse(actual.isPresent());
//		assertThat(employees, hasSize(4));
//		assertThat(employees.size(), is(4));
//		assertThat(employees, IsEmptyCollection.empty());
//		assertThat(employees, hasItems(new EmployeeEntity(), new EmployeeEntity()));
	}

//	@Test
	public void testFindAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		Optional<List<Department>> actual = Optional.of(departments);
		assertThat(actual).isNotNull();
		departments.forEach(emp -> System.out.println(emp));
//		Assert.assertFalse(actual.isPresent());
//		assertThat(employees, hasSize(4));
//		assertThat(employees.size(), is(4));
//		assertThat(employees, IsEmptyCollection.empty());
//		assertThat(employees, hasItems(new EmployeeEntity(), new EmployeeEntity()));
	}

	@Test
	public void testAddEmployee() {
		Employee employee = new Employee();
		employee.setName("New Name12");
		employee.setEmail("NewName12@jdp.com");
		List<Department> departments = new LinkedList<Department>();
		Department dept = new Department();
		dept.setDepartment_id(2);
//		dept.setName("dept2");
		departments.add(dept);
		employee.setDepartment(departments);
		Employee newEmployee = employeeService.addEmployee(employee);
//		Employee newEmployee = employeeService.getEmployeeById(1);
		assertNotNull("Add not successful.", newEmployee);
	}

//	@Test
	public void testUpdateEmployee() {
		Employee employee = employeeService.getEmployeeById(1);
		employee.setName("name1_1");
		Employee updEmployee = employeeService.updateEmployee(employee);
		assertEquals("Update not successful.", employee, updEmployee);
		Employee newEmployee = employeeService.getEmployeeById(1);
		assertEquals("Update not successful.", employee, newEmployee);
	}

//	@Test
	public void testDeleteEmployee() {
		Employee employee = employeeService.getEmployeeById(1);
		employeeService.deleteEmployee(employee);
		Employee newEmployee = employeeService.getEmployeeById(1);
		assertNull("Delete not successful.", newEmployee);
	}

//	@Test
	public void testDeleteEmployeeById() {
		Employee employee = employeeService.getEmployeeById(1);
		employeeService.deleteEmployee(employee);
		Employee newEmployee = employeeService.getEmployeeById(1);
		assertNull("Update not successful.", newEmployee);
	}
}

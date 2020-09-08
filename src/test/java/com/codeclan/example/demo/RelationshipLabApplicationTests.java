package com.codeclan.example.demo;

import com.codeclan.example.demo.models.Department;
import com.codeclan.example.demo.models.Employee;
import com.codeclan.example.demo.models.Project;
import com.codeclan.example.demo.repositories.DepartmentRepository;
import com.codeclan.example.demo.repositories.EmployeeRepository;
import com.codeclan.example.demo.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RelationshipLabApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createDepartmentAndEmployee() {
		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Jane", "Odonnell", 58967, department);
		employeeRepository.save(employee1);
	}

	@Test
	public void addEmployeesAndProjects() {
		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Jane", "Odonnell", 58967, department);
		employeeRepository.save(employee1);

		Project project1 = new Project("Banana", 20);
		projectRepository.save(project1);

		project1.addEmployee(employee1);
		projectRepository.save(project1);

		department.addEmployee(employee1);
		departmentRepository.save(department);
	}
}

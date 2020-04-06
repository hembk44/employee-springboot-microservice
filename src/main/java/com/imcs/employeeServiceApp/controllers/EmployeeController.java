package com.imcs.employeeServiceApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.employeeServiceApp.entity.Employee;
import com.imcs.employeeServiceApp.exceptions.BadDataException;
import com.imcs.employeeServiceApp.exceptions.EmployeeNotFoundException;
import com.imcs.employeeServiceApp.exceptions.InternalServerErrorException;
import com.imcs.employeeServiceApp.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private final String regex = "\\d+";

	@Autowired
	@Qualifier("EmployeeServiceImplJpaRepository")
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getEmployees() throws Exception {
		List<Employee> empList = employeeService.getEmployees();

		if (empList == null) {
			throw new EmployeeNotFoundException("No employees found.");
		}
		return empList;
	}

	@GetMapping("/employees/{empId}")
	public Employee getEmployee(@PathVariable String empId) throws Exception {
		Employee employee = null;
		boolean isNumber = empId.matches(regex);
		if (isNumber) {
			int employeeId = Integer.parseInt(empId);
			employee = employeeService.getEmployee(employeeId);
			if (employee == null) {
				throw new EmployeeNotFoundException("Employee with ID: " + empId + " not found!");
			}
		} else {
			throw new BadDataException("Employee Id must be an integer");
		}
		return employee;

	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) throws Exception {
		employeeService.addEmployee(employee);
		return employee;

	}

	@PutMapping("/employees/{empId}")
	public Employee updateEmployee(@PathVariable String empId, @RequestBody Employee employee) {
		int employeeId = Integer.parseInt(empId);
		employeeService.updateEmployee(employeeId, employee);
		return employeeService.getEmployee(employeeId);
	}

	@DeleteMapping("/employees/{empId}")
	public String deleteEmployee(@PathVariable String empId) {
		String deleteMsg = null;
		Employee employee = null;

		boolean isNumber = empId.matches(regex);
		if (isNumber) {
			int employeeId = Integer.parseInt(empId);
			employee = employeeService.getEmployee(employeeId);
			if (employee == null) {
				throw new EmployeeNotFoundException("Employee with ID: " + empId + " not found!");
			}
			employeeService.deleteEmployee(employeeId);
			deleteMsg = "Employee with ID: " + empId + " is deleted!";
		} else {
			throw new BadDataException("Employee Id must be an integer");
		}
		return deleteMsg;
	}

}

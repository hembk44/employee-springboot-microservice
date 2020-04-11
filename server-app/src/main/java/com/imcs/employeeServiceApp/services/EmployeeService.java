package com.imcs.employeeServiceApp.services;

import java.util.List;

import com.imcs.employeeServiceApp.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public Employee getEmployee(int empId);
	
	public boolean addEmployee(Employee employee);
	
	public boolean deleteEmployee(int empId);
	
	public boolean updateEmployee(int empId, Employee employee);
}

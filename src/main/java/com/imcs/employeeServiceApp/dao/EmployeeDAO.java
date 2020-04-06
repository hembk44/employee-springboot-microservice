package com.imcs.employeeServiceApp.dao;

import java.util.List;

import com.imcs.employeeServiceApp.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee getEmployee(int empId);
	
	public boolean addEmployee(Employee employee);
	
	public boolean deleteEmployee(int empId);
	
	public boolean updateEmployee(int empId, Employee employee);
	
}

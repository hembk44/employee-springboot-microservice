package com.imcs.employeeServiceApp.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imcs.employeeServiceApp.dao.EmployeeDAO;
import com.imcs.employeeServiceApp.entity.Employee;
import com.imcs.employeeServiceApp.services.EmployeeService;

@Service
@Qualifier("EmployeeServiceImplHibernateAndStandardJpa")
public class EmployeeServiceImplHibernateAndStandardJpa implements EmployeeService {

	@Autowired
	@Qualifier("EmployeeDAOJpaImpl")
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {

		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int empId) {
		
		return employeeDAO.getEmployee(empId);
	}

	@Override
	@Transactional
	public boolean addEmployee(Employee employee) {
	
		return employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int empId) {
		
		return employeeDAO.deleteEmployee(empId);
	}

	@Override
	@Transactional
	public boolean updateEmployee(int empId, Employee employee) {
		
		return employeeDAO.updateEmployee(empId, employee);
	}


}

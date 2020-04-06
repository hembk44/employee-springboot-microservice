package com.imcs.employeeServiceApp.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.imcs.employeeServiceApp.entity.Employee;
import com.imcs.employeeServiceApp.repository.EmployeeRepository;
import com.imcs.employeeServiceApp.services.EmployeeService;

@Service
@Qualifier("EmployeeServiceImplJpaRepository")
public class EmployeeServiceImplJpaRepository implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees(){
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(int empId) {
		
		Optional<Employee> result = employeeRepository.findById(empId);
		
		Employee employee = null;
		
		if (result.isPresent()) {
			employee = result.get();
		}
		
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		boolean isAdded = false;
		Employee emp = employeeRepository.save(employee);
		
		if (emp != null) {
			isAdded = true;
		}
		
		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDel = false;
		Employee emp = getEmployee(empId);
		
		if (emp != null) {
			employeeRepository.deleteById(empId);
			isDel = true;
		}
		
		return isDel;
	}

	@Override
	public boolean updateEmployee(int empId, Employee employee) {
		boolean isEmpUpdated = false;
		Employee existingEmp = getEmployee(empId);
		
		if (existingEmp != null) {
			existingEmp.setFirstName(employee.getFirstName());
			existingEmp.setLastName(employee.getLastName());
			existingEmp.setEmailId(employee.getEmailId());
			employeeRepository.save(existingEmp);
			isEmpUpdated = true;
		}
		
		return isEmpUpdated;
	}

	
}

package com.imcs.employeeServiceApp.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.imcs.employeeServiceApp.dao.EmployeeDAO;
import com.imcs.employeeServiceApp.entity.Employee;

@Repository
@Qualifier("EmployeeDAOJpaImpl")
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {

		Query query = entityManager.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployee(int empId) {

		Employee employee = entityManager.find(Employee.class, empId);
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) {

		boolean isEmpAdded = false;

		if (!entityManager.contains(employee)) {
			entityManager.persist(employee);
			isEmpAdded = true;
		}
		return isEmpAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDel = false;
		Employee employee = getEmployee(empId);

		if (employee != null) {

			entityManager.remove(employee);
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
			entityManager.merge(existingEmp);
			isEmpUpdated = true;
		}
		return isEmpUpdated;
	}

}

package com.imcs.employeeServiceApp.dao.implementations;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.imcs.employeeServiceApp.dao.EmployeeDAO;
import com.imcs.employeeServiceApp.entity.Employee;


@Repository
@Qualifier("EmployeeDAOHibernateImpl")
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager
	@Autowired
	private EntityManager entityManager;

	public Session getSession() {
		Session session = entityManager.unwrap(Session.class);
		return session;
	}

	@Override
	public List<Employee> findAll() {

		Session session = getSession();
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> empList = query.getResultList();
		return empList;

	}

	@Override
	public Employee getEmployee(int empId) {

		Session session = getSession();
		Employee employee = session.get(Employee.class, empId);
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) {

		boolean isEmpAdded = false;

		if (!entityManager.contains(employee)) {
			Session session = getSession();
			session.save(employee);
			isEmpAdded = true;
		}
		return isEmpAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {

		boolean isEmpDel = false;
		Session session = getSession();
		Employee employee = session.get(Employee.class, empId);

		if (employee != null) {
			session.delete(employee);
			isEmpDel = true;
		} 

		return isEmpDel;
	}

	@Override
	public boolean updateEmployee(int empId, Employee employee) {
		
		boolean isEmpUpdated = false;
		Session session = getSession();
		Employee emp = session.get(Employee.class, empId);

		if (emp != null) {
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmailId(employee.getEmailId());
			session.update(emp);
			isEmpUpdated = true;
		}

		return isEmpUpdated;
	}

}

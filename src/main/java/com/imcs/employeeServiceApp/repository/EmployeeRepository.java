package com.imcs.employeeServiceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imcs.employeeServiceApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

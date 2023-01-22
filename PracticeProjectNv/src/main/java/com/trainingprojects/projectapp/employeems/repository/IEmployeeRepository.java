package com.trainingprojects.projectapp.employeems.repository;

import java.util.Optional;

import com.trainingprojects.projectapp.employeems.entity.Employee;

public interface IEmployeeRepository {
	Employee save(Employee employee);
	Optional<Employee> findById(long id);

}

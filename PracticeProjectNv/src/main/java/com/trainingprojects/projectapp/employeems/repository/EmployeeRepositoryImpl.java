package com.trainingprojects.projectapp.employeems.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.swing.text.html.Option;

import com.trainingprojects.projectapp.employeems.entity.Employee;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

	private Map<Long, Employee> store = new HashMap<>();

    /**
     * inserts or updates employee in store
     *
     * @param employee
     * @return employee
     */
    @Override
    public Employee save(Employee employee) {
        store.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(long id) {
        if (!store.containsKey(id)) {
            Optional<Employee> optional = Optional.empty();
            return optional;
        }
        Employee employee = store.get(id);
        Optional<Employee> optional = Optional.of(employee);
        return optional;
    }
    
}

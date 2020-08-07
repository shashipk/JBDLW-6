package com.geeksforgeeks.springdatalec5.service;

import com.geeksforgeeks.springdatalec5.entities.Employee;
import com.geeksforgeeks.springdatalec5.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EmployeeService")
public class EmployeeService implements IService<Employee> {
    @Autowired
    // @Autowired annotation allows Spring to resolve and inject collaborating beans into your bean.
    private EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee get(long id) {
       return employeeRepository.findById(id).get();

    }

    @Override
    public void update(Employee object){
        employeeRepository.save(object);
    }
}

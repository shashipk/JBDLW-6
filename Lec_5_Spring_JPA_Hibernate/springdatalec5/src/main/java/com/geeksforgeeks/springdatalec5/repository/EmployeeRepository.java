package com.geeksforgeeks.springdatalec5.repository;

import com.geeksforgeeks.springdatalec5.entities.Employee;
import org.springframework.data.repository.CrudRepository;



//CrudRepository is a Spring Data interface for generic CRUD operations on a repository of a specific type.
// It provides several methods out of the box for interacting with a database.
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}

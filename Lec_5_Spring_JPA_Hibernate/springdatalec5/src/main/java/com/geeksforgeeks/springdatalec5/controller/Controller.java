package com.geeksforgeeks.springdatalec5.controller;

import com.geeksforgeeks.springdatalec5.DepartmentRequest;
import com.geeksforgeeks.springdatalec5.EmployeeRequest;
import com.geeksforgeeks.springdatalec5.entities.Department;
import com.geeksforgeeks.springdatalec5.entities.Employee;
import com.geeksforgeeks.springdatalec5.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    //@Qualifier pin points the implementation of a particular interface/abstraction
    @Qualifier("DepartmentService")
    @Autowired()
    // @Autowired annotation allows Spring to resolve and inject collaborating beans into your bean.
    IService departmentService;
    @Qualifier("EmployeeService")
    @Autowired()
    IService employeeService;

    @PostMapping("/department")
    public ResponseEntity<String> createDepartment(@RequestBody DepartmentRequest req){
        Department department = new Department();
        department.setDepartment_name(req.getDepartmentName());
        departmentService.create(department);
        return ResponseEntity.accepted().build();

    }

    @PostMapping("/employee")
    public ResponseEntity<String > createEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDepartment((Department) departmentService.get(employeeRequest.getDepartmentId()));
        employeeService.create(employee);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String > updateEmployee(@PathVariable("id") long id,
                                                  @RequestBody EmployeeRequest employeeRequest){
        Employee employee = (Employee) employeeService.get(id);
        employee.setPhoneNumber(employeeRequest.getPhoneNumber());

        employeeService.create(employee);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/department")
    public ResponseEntity<Department> getDepartment(){
        return null;
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id){

        return ResponseEntity
                .ok((Employee) employeeService.get(Long.valueOf(id)));
    }



}

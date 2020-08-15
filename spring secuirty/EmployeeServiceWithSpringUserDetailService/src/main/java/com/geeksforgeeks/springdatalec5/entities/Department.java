package com.geeksforgeeks.springdatalec5.entities;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Department implements Serializable{
    //@Id create primary key
    @Id
    //Automatically generates and maintain id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false) //department name should not be null
    private String department_name;
    //One to Many Relation
    //the mappedBy attribute is used to define the referencing side (non-owning side) of the relationship.
    //Many employees are mapped to one department.
    //mapped by should take the field name of reference in Employee class
    @OneToMany(mappedBy = "department")
    //Don't create getter setter for employees. As Department table only has department id and name.
    //If you create getter setter jackson will create infinite parent child relationship.Give it a try
    private List<Employee> employees;

    public Department(long id, String department_name) {
        this.id = id;
        this.department_name = department_name;
    }
    public Department() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}

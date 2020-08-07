package com.geeksforgeeks.springdatalec5.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false) //first name shouldn't be null
    private String firstName;
    @Column(nullable = false) //first name shouldn't be null
    private String lastName;
    //Many to one relation
    @ManyToOne(cascade = CascadeType.ALL)
    // @JoinColumn annotation helps us specify the column
    // we'll use for joining an entity association or element collection.
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
    private String phoneNumber;

    public Employee(long id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

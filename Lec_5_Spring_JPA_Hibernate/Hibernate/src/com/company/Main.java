package com.company;
//Download hibernate distribution from https://hibernate.org/orm/releases/5.2/
//Add required libs from dist of hibernate to your classpath
public class Main {

    public static void main(String[] args) {
	// write your code here
        Department department = new Department(1,"Human Resource");
        Employee employee = new Employee(1,"Saptarshi","Polley",1, "12345");


        Repository repository = new Repository();
        repository.save(employee);
        Employee result = (Employee) repository.get(Employee.class, 1);

        System.out.println(result.getFirstName());
        employee.setFirstName("John");
        repository.update(employee);

        result = (Employee) repository.get(Employee.class, 1);

        repository.delete(result);

        System.out.println(result.getFirstName());
    }
}

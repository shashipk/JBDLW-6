CREATE TABLE `employee` (
  `id` bigint(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `department_id` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)

CREATE TABLE `department` (
  `id` bigint(255) NOT NULL,
  `department_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO employee
(`id`,`first_name`,`last_name`,`department_id`,`salary`)
VALUES
(1,'Sandeep','Roy',1,50000);

INSERT INTO department
(`id`,`department_name`)
VALUES
(1,'Human Resource');

ALTER TABLE employee
ADD
`phone_number` varchar(255) NOT NULL;

ALTER TABLE employee
DROP
`phone_number`;

#Get the total sum of salary spent on Finance department
Select sum(salary), department_name from employee, department
where employee.department_id = department.id
Group by department_name having department.department_name = "Finance";

#Get the employees who are working in human resource department
JdbcTutorialSelect employee.`first_name` from employee, department
where employee.department_id = department.id
and department_name='Human Resource';

CREATE TABLE employee(
	
	id IDENTITY,
	name VARCHAR(50),
	email VARCHAR(50),
	mobile VARCHAR(50),
	salary DOUBLE,
	joiningDate CURRENT_DATE,
	role VARCHAR(50),
	
	CONSTRAINT pk_employee_id PRIMARY KEY (id)

);
insert into Employee ( id,name,email,mobile,salary, joiningDate,role) values (5, BBB, bbb@gmail.com, 8308779955, 56234, now(), devloper);
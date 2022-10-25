create database dummy;
use dummy;
create table department (
id int primary key auto_increment, 
deptName text
);
create table employee (
id int primary key auto_increment,
 empName text,
 age int,
 deptId int,
foreign key (deptId) references department(id)
);


insert into department (deptName) values ('Consumer Lending');
insert into department (deptName) values ('Private Equity');
insert into department (deptName) values ('Investment Banking');

insert into employee (empName,age,deptId) values ('Abhyudita',21,1);
insert into employee (empName,age,deptId) values ('Saurabh',21,2);
insert into employee (empName,age,deptId) values ('Utkarsh',22,3);
insert into employee (empName,age,deptId) values ('Harsh',22,3);
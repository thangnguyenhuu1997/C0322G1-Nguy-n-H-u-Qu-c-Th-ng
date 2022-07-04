create database case_study;
use case_study;

create table position (
position_id int auto_increment primary key,
position_name varchar(45)
);

create table education_degree (
education_degree_id int auto_increment primary key,
education_degree_name varchar(45)
);

create table division (
division_id int auto_increment primary key,
division_name varchar(45)
);

create table `user`(
username varchar(255) primary key,
`password` varchar(255)
);

create table employee(
employee_id int primary key auto_increment,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) unique not null,
employee_salary double not null,
employee_phone varchar(45) not null,
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
foreign key (position_id) references position (position_id),
foreign key (education_degree_id) references education_degree(education_degree_id),
foreign key (division_id) references division(division_id),
foreign key (username) references `user`(username)
);

create table `role` (
role_id int auto_increment primary key,
role_name varchar(255)
);

create table user_role(
role_id int,
username varchar(255),
foreign key(role_id) references `role`(role_id),
foreign key(username) references `user`(username)
);

create table customer_type(
customer_type_id int auto_increment primary key,
customer_type_name varchar(45)
);

create table customer(
customer_id int auto_increment primary key,
customer_type_id int,
customer_name varchar(45) not null,
customer_birthday date not null,
customer_gender bit(1) not null,
customer_id_card varchar(45) not null,
customer_phone varchar(45) not null,
customer_email varchar(45),
customer_address varchar(45),
foreign key (customer_type_id) references customer_type(customer_type_id)
);

create table facility_type(
facility_type_id int auto_increment primary key,
facility_type_name varchar(45)
);

create table rent_type (
rent_type_id int auto_increment primary key,
rent_type_name varchar(45)
);

create table facility (
facility_id int auto_increment primary key,
facility_name varchar(45) not null,
facility_area int,
facility_cost double not null,
facility_max_people int,
rent_type_id int,
facility_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int,
facility_free text
);

create table contract(
contract_id int auto_increment primary key,
contract_start_date datetime not null,
contract_end_date datetime not null,
contract_deposit double not null,
employee_id int,
customer_id int,
service_id int,
facility_id int,
foreign key (employee_id) references employee(employee_id),
foreign key (customer_id) references customer(customer_id),
foreign key (facility_id) references facility(facility_id)
);

create table attach_facility (
attach_facility_id int auto_increment primary key,
attach_facility_name varchar(45) not null,
attach_facility_cost double not null,
attach_facility_unit varchar(10),
attach_facility_status varchar(45)
);

create table contract_detail (
contract_detail_id int auto_increment primary key,
contract_id int,
attach_facility_id int,
quantity int not null,
foreign key (contract_id) references contract(contract_id),
foreign key (attach_facility_id) references attach_facility(attach_facility_id)
)benhan
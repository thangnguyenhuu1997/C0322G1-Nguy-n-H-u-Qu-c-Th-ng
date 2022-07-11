create database c10;
use c10;

create table category (
category_id int auto_increment primary key,
category_name varchar(100)
);

create table product (
product_id int auto_increment primary key,
product_name varchar(100),
product_price double,
product_quantity int,
product_color varchar(200),
category_id int,
foreign key (category_id) references category(category_id)
);

insert into category
values (1, 'Laptop'),
	   (2, 'television'),
	   (3, 'phone');

insert into product values 
	(1, 'Acer', 7000000,10,'red,black',1),
	(2, 'Samsung', 10000000,10,'black',3),
	(3, 'Sony', 30000000,20,'black',2);
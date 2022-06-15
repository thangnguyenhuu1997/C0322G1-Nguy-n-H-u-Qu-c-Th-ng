create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer (
customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
customer_name varchar(100),
customer_age int
);
create table `order` (
order_id INT NOT NULL PRIMARY KEY,
customer_id INT NOT NULL,
order_date DATE,
order_total_prince int,
FOREIGN KEY (customer_id) references Customer (customer_id)
);
create table product (
product_id INT NOT NULL PRIMARY KEY,
product_name varchar(100),
product_prince int
);
create table orderdetail (
order_id int not null,
product_id int not null,
odQTY varchar(100),
primary key (order_id, product_id),
FOREIGN KEY (order_id) references `order`(order_id),
FOREIGN KEY (product_id) references product (product_id)
);
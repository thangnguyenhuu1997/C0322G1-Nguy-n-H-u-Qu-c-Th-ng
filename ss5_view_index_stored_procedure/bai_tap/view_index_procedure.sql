create database demo;
use demo;

create table products(
id int primary key auto_increment,
productCode varchar (50),
productName varchar (50),
productPrice  double,
productAmount int,
productDescription varchar (50),
productStatus varchar(30)
);
insert into products (productCode,productName,productPrice,productAmount,productDescription,productStatus) values
('1ab', 'ABC', 3000, 10,'Alphabet', 'Sold out'), ('2bc','123', 3000, 10,"Number", 'on sale');
create unique index index_product on products (productCode);

create index composite_index on products (productName, productPrice);

explain select * from products where productCode like '1ab';

create view view_product as
select productCode, productName, productPrice,productStatus from products;

update view_product set productCode = '3cd' where productCode = '1ab';
select * from view_product;
select * from products;
drop view view_product;

delimiter // 
create procedure sp_product()
begin 
select * from products;
end //
delimiter ;

call sp_product();

delimiter //
create procedure sp_newProduct(
productCode varchar(50), 
productName varchar(50), 
productPrice double, 
productAMount int, 
productDescription varchar(50), 
productStatus varchar(50))
begin
	insert into products (productCode, productName, productPrice, productAMount, productDescription, productStatus) values
    ( productCode, productName, productPrice, productAMount, productDescription, productStatus);
end // 
delimiter ;

call sp_newProduct ('5lk', "Thang", 2000, 2,"To", "con");

delimiter //
create procedure update_product (id_product int)
begin
update products
set productName = "Linh" where id = id_product;
end //
delimiter ;

call update_product (2);

delimiter //
create procedure delete_product (id_product int)
begin
delete from products
 where id = id_product;
end //
delimiter ;

call delete_product(3);

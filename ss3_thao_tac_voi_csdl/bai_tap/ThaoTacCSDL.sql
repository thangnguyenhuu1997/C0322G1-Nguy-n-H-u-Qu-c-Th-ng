use quanlybanhang;
insert into customer(customer_name,customer_age)
value ('Minh Quan',10), 
('Ngoc Oanh', 20),
('Hong Ha', 50);

insert into `order`(order_id,customer_id,order_date)
values (1,1,'2006-03-21'),
	   (2,2,'2006-03-23'),
       (3,1,'2006-03-16');
       
insert into product (product_id,product_name,product_prince)
value (1,'May giat',3),
(2,'Tu lanh',7),
(3,'Dieu Hoa',2),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into orderdetail (order_id,product_id,odQTY)
value (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select order_id, customer_id, order_date from `order`;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select customer.customer_name, product.product_name from customer
inner join `order` on `order`.customer_id = customer.customer_id
inner join orderdetail on `order`.order_id = orderdetail.order_id
inner join product on orderdetail.product_id = product.product_id;

select customer.customer_name from customer where customer.customer_id not in (select customer_id from `order`);
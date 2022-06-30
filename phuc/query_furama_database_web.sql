use furama_resort_web_servlet;
select * from employee where employee_id = 3;
update employee set employee_name = 'Trần Mạnh Cường', employee_birthday = '1997-09-09', employee_id_card = '09990909', employee_salary = 900, employee_phone = '113112', employee_email = 'manhcuong@gmail.com', employee_address = 'Quảng Bình', position_id = 1, education_degree_id = 1, division_id = 1, username = 'duytrung@gmail.com' where employee_id = 3;
UPDATE `employee` SET `employee_name` = 'Huỳnh Nhật Hoàngg', `employee_birthday` = '1996-05-11', `employee_id_card` = '333444556', `employee_salary` = '459', `employee_phone` = '064577888', `employee_email` = 'nhathoang@gmail.co', `employee_address` = 'Đà Nẵng1', `position_id` = '2', `education_degree_id` = '2', `division_id` = '2', `username` = 'nhathoang@gmail.com1' WHERE (`employee_id` = '3');
insert into `user` values ('abc','abc');

-- Thêm dữ liệu vào bảng position --
insert into `position` (position_name) values ('Lễ tân');
insert into `position` (position_name) values ('Phục vụ');
insert into `position` (position_name) values ('Chuyên viên');
insert into `position` (position_name) values ('Giám sát');
insert into `position` (position_name) values ('Quản lý');
insert into `position` (position_name) values ('Giám đốc');

-- Thêm dữ liệu vào bảng education_degree --
insert into education_degree (education_degree_name) values ('Trung cấp');
insert into education_degree (education_degree_name) values ('Cao đẳng');
insert into education_degree (education_degree_name) values ('Đại học');
insert into education_degree (education_degree_name) values ('Sau đại học');

-- Thêm dữ liệu vào bảng division --
insert into division (division_name) values ('Sale-marketing');
insert into division (division_name) values ('Hành chính');
insert into division (division_name) values ('Phục vụ');
insert into division (division_name) values ('Quản lý');

-- Thêm dữ liệu vào bảng user --
insert into `user` values ('quangphuc@gmail.com','123123');
insert into `user` values ('thienduy@gmail.com','123123');
insert into `user` values ('duytrung@gmail.com','123123');
insert into `user` values ('nhathoang@gmail.com','123123');

-- Thêm dữ liệu vào bảng employee --
insert into employee (employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone,
			employee_email, employee_address, position_id, education_degree_id, division_id, username)
values ('Nguyễn Quang Phúc','1998-06-29','111222333',500,'0123123123','quangphuc@gmail.com','Đà Nẵng',5,4,4,'quangphuc@gmail.com'),
	   ('Nguyễn Thiên Duy','1995-04-13','222333444',400,'0123412445','thienduy@gmail.com','Quảng Nam',6,4,4,'thienduy@gmail.com'),
       ('Huỳnh Nhật Hoàng','1996-05-16','333444555',450,'064577887','nhathoang@gmail.com','Đà Nẵng',1,3,3,'nhathoang@gmail.com'),
       ('Nguyễn Duy Trung','2003-09-06','444555666',600,'8674646343','duytrung@gmail.com','Quảng Nam',2,2,2,'duytrung@gmail.com');
       
-- Thêm dữ liệu vào bảng customer_type -- 
insert into customer_type (customer_type_name) values ('Diamond');
insert into customer_type (customer_type_name) values ('Platinium');
insert into customer_type (customer_type_name) values ('Gold');
insert into customer_type (customer_type_name) values ('Silver');
insert into customer_type (customer_type_name) values ('Member');

-- Thêm dữ liệu vào bảng customer --
insert into customer (customer_code,customer_type_id, customer_name, customer_birth, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values ('KH-0001',1, 'Trần Văn Khánh', '1995-02-01', 0, '123111222', '0798584942', 'khanhtran@gmail.com', 'Quảng Bình'),
	   ('KH-0002',3, 'Nguyễn Hoàng Hảo', '2000-09-02', 0, '342325665','0949648638','hoanghao@gmail.com','Đà Nẵng'),
       ('KH-0003',4, 'Trần Mạnh Cường', '1997-08-06', 0, '786744564','0346534633', 'manhcuong@gmail.com', 'Quảng Bình'),
       ('KH-0004',5, 'Nguyễn Thảo Uyên', '2000-12-12',1,'2352352352','04564564456','thaouyen@gmail.com','Quảng Ngãi');

-- Thêm dữ liệu vào bảng service_type --
insert into service_type (service_type_name) values ('Standard');
insert into service_type (service_type_name) values ('Deluxe');
insert into service_type (service_type_name) values ('President');
insert into service_type (service_type_name) values ('VIP');

-- Thêm dữ liệu vào bảng rent_type --
insert into rent_type (rent_type_name, rent_type_cost) values ('Năm', 100);
insert into rent_type (rent_type_name, rent_type_cost) values ('Tháng', 80);
insert into rent_type (rent_type_name, rent_type_cost) values ('Ngày', 50);
insert into rent_type (rent_type_name, rent_type_cost) values ('Giờ', 30);

-- Thêm dữ liệu vào bảng service --

-- insert Villa --
insert into service (service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floor)
			values ('Villa-01', 200, 800, 11, 2, 3, 'President', 'None', 30, 2),
				   ('Villa-02', 300, 900, 5, 3, 2, 'Deluxe', 'None', 30, 1);
                   
-- insert House --
insert into service (service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, number_of_floor) 
			values ('House-01', 130, 700, 8, 4, 2, 'Standard', 'None', 2),
				   ('House-02', 150, 600, 7, 3, 3, 'President', 'None', 3);
                   
-- insert Room --
insert into service (service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, description_other_convenience) 
			values ('Room-01', 80, 200, 4, 4, 1, 'None'),
				   ('Room-02', 100, 300, 4, 4, 1, 'None');
create database if not exists furama_resort_web;
use furama_resort_web;

create table position (
position_id int primary key,
position_name varchar(45),
flag bit(1) default 0
);

create table education_degree (
education_degree_id int primary key,
education_degree_name varchar(45),
flag bit(1) default 0
);

create table division (
division_id int primary key,
division_name varchar(45),
flag bit(1) default 0
);

create table facility_type (
facility_type_id int primary key,
facility_type_name varchar(45),
flag bit(1) default 0
);

create table customer_type (
customer_type_id int primary key,
customer_type_name varchar(45),
flag bit(1) default 0
);

create table rent_type (
rent_type_id int primary key,
rent_type_name varchar(45),
flag bit(1) default 0
);

create table `user` (
username varchar(255) primary key,
`password` varchar(255),
flag bit(1) default 0
);

create table `role` (
role_id int primary key,
role_name varchar(255),
flag bit(1) default 0
);

create table user_role (
role_id int,
username varchar(255),
flag bit(1) default 0,
primary key (role_id, username),
foreign key (role_id) references `role` (role_id),
foreign key (username) references `user` (username)
);

create table attach_facility (
attach_facility_id int primary key,
attach_facility_name varchar(45),
attach_facility_cost double,
attach_facility_unit varchar(10),
attach_facility_status varchar(45),
flag bit(1) default 0
);

create table employee (
employee_id int primary key,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary double,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,
education_degree_id int,
division_id int,
username varchar(255),
flag bit(1) default 0,
foreign key (position_id) references position (position_id),
foreign key (education_degree_id) references education_degree (education_degree_id),
foreign key (division_id) references division (division_id),
foreign key (username) references `user` (username)
);

create table customer (
customer_id int primary key,
customer_type_id int,
customer_name varchar(45),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45),
flag bit(1) default 0,
foreign key (customer_type_id) references customer_type (customer_type_id)
);

create table facility (
facility_id int primary key,
facility_name varchar(45),
facility_area int,
facility_cost double,
facility_max_people int,
rent_type_id int,
facility_type_id int,
standard_room varchar(45),
description_other_convenence varchar(45),
pool_area double,
number_of_floors int,
facility_free text,
flag bit(1) default 0,
foreign key (rent_type_id) references rent_type (rent_type_id),
foreign key (facility_type_id) references facility_type (facility_type_id)
);

create table contract (
contract_id int primary key,
contract_start_date datetime,
contract_end_date datetime,
contract_deposit double,
employee_id int,
customer_id int,
facility_id int,
flag bit(1) default 0,
foreign key (employee_id) references employee (employee_id),
foreign key (customer_id) references customer (customer_id),
foreign key (facility_id) references facility (facility_id)
);

create table contract_detail (
contract_detail_id int primary key,
contract_id int,
attach_facility_id int,
quantity int,
flag bit(1) default 0,
foreign key (contract_id) references contract (contract_id),
foreign key (attach_facility_id) references attach_facility (attach_facility_id)
);

insert into position
values (1, 'Lễ tân', 0),
	   (2, 'Phục vụ', 0),
	   (3, 'Chuyên viên', 0),
	   (4, 'Giám sát', 0),
	   (5, 'Quản lý', 0),
	   (6, 'Giám đốc', 0);

insert into education_degree
values (1, 'Trung cấp', 0),
	   (2, 'Cao đẳng', 0),
	   (3, 'Đại học', 0),
	   (4, 'Sau đại học', 0);
       
insert into division
values (1, 'Sale – Marketing', 0),
	   (2, 'Hành chính', 0),
	   (3, 'Phục vụ', 0),
	   (4, 'Quản lý', 0);
       
insert into facility_type
values (1, 'Villa', 0),
	   (2, 'House', 0),
	   (3, 'Room', 0);

insert into customer_type
values (1, 'Diamond', 0),
	   (2, 'Platinium', 0),
	   (3, 'Gold', 0),
	   (4, 'Silver', 0),
	   (5, 'Member', 0);
       
insert into rent_type
values (1, 'Năm', 0),
	   (2, 'Tháng', 0),
	   (3, 'Ngày', 0),
	   (4, 'Giờ', 0);
       
insert into `user`
values ('levanan', 'levanan', 0),
	   ('lengocanh', 'lengocanh', 0),
	   ('tranvansau', 'tranvansau', 0);
       
insert into `role`
values (1, 'admin', 0),
	   (2, 'super', 0),
	   (3, 'user', 0);
       
insert into user_role  
values (1, 'levanan', 0),
	   (2, 'lengocanh', 0),
	   (3, 'tranvansau', 0);
       
insert into attach_facility 
values (1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại', 0),
	   (2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe', 0),
	   (3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt', 0),
	   (4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng', 0),
	   (5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng', 0),
	   (6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng', 0); 
       
insert into employee 
values (1, 'Lê Văn An', '1980-02-25', '2045096345', 20000000, '0987654321', 'levanan@gmail.com', 'Đà Nẵng', 6, 4, 4, 'levanan', 0),
	   (2, 'Lê Ngọc Anh', '1992-11-12', '2045096325', 15000000, '0987653321', 'lengocanh@gmail.com', 'Quảng Nam', 3, 3, 2, 'lengocanh', 0),
	   (3, 'Trần Văn Sáu', '1991-06-24', '2045096395', 10000000, '0987694321', 'tranvansau@gmail.com', 'Huế', 2, 1, 2, 'tranvansau', 0),
	   (4, 'Nguyễn Văn An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1, 'tranvansau', 0),
	   (5, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0931234121', 'binh@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2, 'tranvansau', 0),
	   (6, 'Hồ Thị Yến', '1995-12-12', '999231723', 12000000, '0921234121', 'yen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2, 'tranvansau', 0),
	   (7, 'Võ Công Toản', '1980-04-04', '123231365', 3000000, '0961234121', 'toan@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4, 'tranvansau', 0),
	   (8, 'Nguyễn Bỉnh Phát', '1999-12-09', '456341786', 5000000, '0981234121', 'phat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1, 'tranvansau', 0),
	   (9, 'Khúc Nguyễn An Nghi', '2000-11-08', '126231786', 7000000, '0931234121', 'nghi@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3, 'tranvansau', 0),
	   (10, 'Nguyễn Hữu Hà', '1993-01-01', '456231786', 6000000, '0901264121', 'ha@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2, 'tranvansau', 0),
	   (11, 'Nguyễn Hà Đông', '1989-09-03', '496231786', 8000000, '0911234121', 'dong@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4, 'tranvansau', 0),
	   (12, 'Tòng Hoang', '1982-09-03', '826231786', 9000000, '0921234121', 'hoang@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4, 'tranvansau', 0),
	   (13, 'Nguyễn Công Đạo', '1994-01-08', '946231786', 4000000, '0971234121', 'dao@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2, 'tranvansau', 0);
       
insert into customer
values (1, 5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0987654321', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', 0),
	 (2, 3, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0987654321', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', 0),
	 (3, 1, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0987654321', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', 0),
	 (4, 1, 'Dương Văn Quan', '1981-07-08', 1, '634635974', '0987654321', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', 0),
	 (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '241234757', '0987654321', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', 0),
	 (6, 4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '956352456', '0987654321', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', 0),
	 (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '445682467', '0987654321', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', 0),
	 (8, 3, 'Nguyễn Thị Hào', '1999-04-08', 0, '456789034', '0987654321', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', 0),
	 (9, 1, 'Trần Đại Danh', '1994-07-01', 1, '456788956', '0987654321', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', 0),
	 (10, 2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '435678954', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', 0);     
     
insert into facility
values (1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4, null, 0),
	   (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3, null,  0),
	   (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null, 'Nước lọc', 0),
	   (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3, null, 0),
	   (5, 'House Princess 02', 10000, 4000000, 5,  3, 2, 'normal', 'Có thêm bếp nướng', null, 2, null, 0),
	   (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null, 'Nước lọc', 0);

insert into contract 
values (1, '2020-12-08', '2020-12-08', 0, 3, 1, 3, 0),
	   (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1, 0),
	   (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2, 0),
	   (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5, 0),
	   (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6, 0),
	   (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6, 0),
	   (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4, 0),
	   (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1, 0),
	   (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3, 0),
	   (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5, 0),
	   (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1, 0),
	   (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1, 0);
       
insert into contract_detail
values (1, 2, 4, 5, 0),
	   (2, 2, 5, 8, 0),
       (3, 2, 6, 15, 0),
	   (4, 3, 1, 1, 0),
	   (5, 3, 2, 11, 0),
	   (6, 1, 3, 1, 0),
	   (7, 1, 2, 2, 0),
	   (8, 12, 2, 2, 0);

select * from attach_facility
join contract_detail on attach_facility.attach_facility_id = contract_detail.attach_facility_id
join contract on contract_detail.contract_id = contract.contract_id;

select contract.contract_id, contract.contract_start_date, contract.contract_end_date, contract.contract_deposit, contract.employee_id, contract.customer_id, contract.facility_id,
 contract_detail.contract_detail_id, contract_detail.quantity,
 attach_facility.attach_facility_id, attach_facility.attach_facility_name, attach_facility.attach_facility_cost, attach_facility.attach_facility_unit, attach_facility.attach_facility_status
from contract
 join contract_detail on contract.contract_id = contract_detail.contract_id
 join attach_facility on attach_facility.attach_facility_id = contract_detail.attach_facility_id 
 where contract.contract_id = 1;
 
delimiter //
create trigger save_account
before insert
on employee for each row
begin
     insert into `user` (`username`, `password`)
     values ( new.employee_email, '123456') ;

    if new.`username`  is null then 
         set new.`username` = new.employee_email ;
    end if;
end;
// delimiter ;   

insert into employee (employee_id, employee_email)
values (20,'levanan@gmail.com');

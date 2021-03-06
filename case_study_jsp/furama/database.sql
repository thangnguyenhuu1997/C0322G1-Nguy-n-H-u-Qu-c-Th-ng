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
);

insert into position
values (1, 'L??? t??n'),
	   (2, 'Ph???c v???'),
	   (3, 'Chuy??n vi??n'),
	   (4, 'Gi??m s??t'),
	   (5, 'Qu???n l??'),
	   (6, 'Gi??m ?????c');
insert into education_degree
values (1, 'Trung c???p'),
	   (2, 'Cao ?????ng'),
	   (3, '?????i h???c'),
	   (4, 'Sau ?????i h???c');
insert into division
values (1, 'Sale ??? Marketing'),
	   (2, 'H??nh ch??nh'),
	   (3, 'Ph???c v???'),
	   (4, 'Qu???n l??');
insert into facility_type
values (1, 'Villa'),
	   (2, 'House'),
	   (3, 'Room');
insert into customer_type
values (1, 'Diamond'),
	   (2, 'Platinium'),
	   (3, 'Gold'),
	   (4, 'Silver'),
	   (5, 'Member');
insert into rent_type
values (1, 'N??m'),
	   (2, 'Th??ng'),
	   (3, 'Ng??y'),
	   (4, 'Gi???');
insert into `user`
values ('levanan', 'levanan'),
	   ('lengocanh', 'lengocanh'),
	   ('tranvansau', 'tranvansau');
insert into `role`
values (1, 'admin'),
	   (2, 'super'),
	   (3, 'user');
insert into user_role
values (1, 'levanan'),
	   (2, 'lengocanh'),
	   (3, 'tranvansau');
insert into attach_facility
values (1, 'Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n t???i'),
	   (2, 'Thu?? xe m??y', 10000, 'chi???c', 'h???ng 1 xe'),
	   (3, 'Thu?? xe ?????p', 20000, 'chi???c', 't???t'),
	   (4, 'Buffet bu???i s??ng', 15000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
	   (5, 'Buffet bu???i tr??a', 90000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng'),
	   (6, 'Buffet bu???i t???i', 16000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng');
insert into employee
values (1, 'L?? V??n An', '1980-02-25', '2045096345', 20000000, '0987654321', 'levanan@gmail.com', '???? N???ng', 6, 4, 4, 'levanan'),
	   (2, 'L?? Ng???c Anh', '1992-11-12', '2045096325', 15000000, '0987653321', 'lengocanh@gmail.com', 'Qu???ng Nam', 3, 3, 2, 'lengocanh'),
	   (3, 'Tr???n V??n S??u', '1991-06-24', '2045096395', 10000000, '0987694321', 'tranvansau@gmail.com', 'Hu???', 2, 1, 2, 'tranvansau'),
	   (4, 'Nguy???n V??n An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng', 1, 3, 1, 'tranvansau'),
	   (5, 'L?? V??n B??nh', '1997-04-09', '654231234', 7000000, '0931234121', 'binh@gmail.com', '22 Y??n B??i, ???? N???ng', 1, 2, 2, 'tranvansau'),
	   (6, 'H??? Th??? Y???n', '1995-12-12', '999231723', 12000000, '0921234121', 'yen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', 1, 3, 2, 'tranvansau'),
	   (7, 'V?? C??ng To???n', '1980-04-04', '123231365', 3000000, '0961234121', 'toan@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', 1, 4, 4, 'tranvansau'),
	   (8, 'Nguy???n B???nh Ph??t', '1999-12-09', '4563417186', 5000000, '0981234121', 'phat@gmail.com', '43 Y??n B??i, ???? N???ng', 2, 1, 1, 'tranvansau'),
	   (9, 'Kh??c Nguy???n An Nghi', '2000-11-08', '126231786', 7000000, '0931234121', 'nghi@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', 2, 2, 3, 'tranvansau'),
	   (10, 'Nguy???n H???u H??', '1993-01-01', '4562321786', 6000000, '0901264121', 'ha@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', 2, 3, 2, 'tranvansau'),
	   (11, 'Nguy???n H?? ????ng', '1989-09-03', '49612317836', 8000000, '0911234121', 'dong@gmail.com', '111 H??ng V????ng, H?? N???i', 2, 4, 4, 'tranvansau'),
	   (12, 'T??ng Hoang', '1982-09-03', '826231786', 9000000, '0921234121', 'hoang@gmail.com', '213 H??m Nghi, ???? N???ng', 2, 4, 4, 'tranvansau'),
	   (13, 'Nguy???n C??ng ?????o', '1994-01-08', '946231786', 4000000, '0971234121', 'dao@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', 2, 3, 2, 'tranvansau');
insert into customer
values (1, 5, 'Nguy???n Th??? H??o', '1970-11-07', 0, '643431213', '0987654321', 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng'),
	 (2, 3, 'Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0987654321', 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???'),
	 (3, 1, 'Tr????ng ????nh Ngh???', '1990-02-27', 1, '488645199', '0987654321', 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh'),
	 (4, 1, 'D????ng V??n Quan', '1981-07-08', 1, '634635974', '0987654321', 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng'),
	 (5, 4, 'Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, '241234757', '0987654321', 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai'),
	 (6, 4, 'T??n N??? M???c Ch??u', '2005-12-06', 0, '956352456', '0987654321', 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng'),
	 (7, 1, 'Nguy???n M??? Kim', '1984-04-08', 0, '445682467', '0987654321', 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh'),
	 (8, 3, 'Nguy???n Th??? H??o', '1999-04-08', 0, '456789034', '0987654321', 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum'),
	 (9, 1, 'Tr???n ?????i Danh', '1994-07-01', 1, '456788956', '0987654321', 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
	 (10, 2, 'Nguy???n T??m ?????c', '1989-07-01', 1, '435678954', '0987654321', 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng');
insert into facility
values (1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'C?? h??? b??i', 500, 4, null),
	   (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'C?? th??m b???p n?????ng', null, 3, null),
	   (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'C?? tivi', null, null, 'N?????c l???c'),
	   (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'C?? h??? b??i', 300, 3, null),
	   (5, 'House Princess 02', 10000, 4000000, 5,  3, 2, 'normal', 'C?? th??m b???p n?????ng', null, 2, null),
	   (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'C?? tivi', null, null, 'N?????c l???c');
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
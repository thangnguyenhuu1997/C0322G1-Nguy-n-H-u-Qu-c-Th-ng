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
values (1, 'L??? t??n', 0),
	   (2, 'Ph???c v???', 0),
	   (3, 'Chuy??n vi??n', 0),
	   (4, 'Gi??m s??t', 0),
	   (5, 'Qu???n l??', 0),
	   (6, 'Gi??m ?????c', 0);

insert into education_degree
values (1, 'Trung c???p', 0),
	   (2, 'Cao ?????ng', 0),
	   (3, '?????i h???c', 0),
	   (4, 'Sau ?????i h???c', 0);
       
insert into division
values (1, 'Sale ??? Marketing', 0),
	   (2, 'H??nh ch??nh', 0),
	   (3, 'Ph???c v???', 0),
	   (4, 'Qu???n l??', 0);
       
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
values (1, 'N??m', 0),
	   (2, 'Th??ng', 0),
	   (3, 'Ng??y', 0),
	   (4, 'Gi???', 0);
       
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
values (1, 'Karaoke', 10000, 'gi???', 'ti???n nghi, hi???n t???i', 0),
	   (2, 'Thu?? xe m??y', 10000, 'chi???c', 'h???ng 1 xe', 0),
	   (3, 'Thu?? xe ?????p', 20000, 'chi???c', 't???t', 0),
	   (4, 'Buffet bu???i s??ng', 15000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng', 0),
	   (5, 'Buffet bu???i tr??a', 90000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng', 0),
	   (6, 'Buffet bu???i t???i', 16000, 'su???t', '?????y ????? ????? ??n, tr??ng mi???ng', 0); 
       
insert into employee 
values (1, 'L?? V??n An', '1980-02-25', '2045096345', 20000000, '0987654321', 'levanan@gmail.com', '???? N???ng', 6, 4, 4, 'levanan', 0),
	   (2, 'L?? Ng???c Anh', '1992-11-12', '2045096325', 15000000, '0987653321', 'lengocanh@gmail.com', 'Qu???ng Nam', 3, 3, 2, 'lengocanh', 0),
	   (3, 'Tr???n V??n S??u', '1991-06-24', '2045096395', 10000000, '0987694321', 'tranvansau@gmail.com', 'Hu???', 2, 1, 2, 'tranvansau', 0),
	   (4, 'Nguy???n V??n An', '1970-11-07', '456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguy???n T???t Th??nh, ???? N???ng', 1, 3, 1, 'tranvansau', 0),
	   (5, 'L?? V??n B??nh', '1997-04-09', '654231234', 7000000, '0931234121', 'binh@gmail.com', '22 Y??n B??i, ???? N???ng', 1, 2, 2, 'tranvansau', 0),
	   (6, 'H??? Th??? Y???n', '1995-12-12', '999231723', 12000000, '0921234121', 'yen@gmail.com', 'K234/11 ??i???n Bi??n Ph???, Gia Lai', 1, 3, 2, 'tranvansau', 0),
	   (7, 'V?? C??ng To???n', '1980-04-04', '123231365', 3000000, '0961234121', 'toan@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???', 1, 4, 4, 'tranvansau', 0),
	   (8, 'Nguy???n B???nh Ph??t', '1999-12-09', '456341786', 5000000, '0981234121', 'phat@gmail.com', '43 Y??n B??i, ???? N???ng', 2, 1, 1, 'tranvansau', 0),
	   (9, 'Kh??c Nguy???n An Nghi', '2000-11-08', '126231786', 7000000, '0931234121', 'nghi@gmail.com', '294 Nguy???n T???t Th??nh, ???? N???ng', 2, 2, 3, 'tranvansau', 0),
	   (10, 'Nguy???n H???u H??', '1993-01-01', '456231786', 6000000, '0901264121', 'ha@gmail.com', '4 Nguy???n Ch?? Thanh, Hu???', 2, 3, 2, 'tranvansau', 0),
	   (11, 'Nguy???n H?? ????ng', '1989-09-03', '496231786', 8000000, '0911234121', 'dong@gmail.com', '111 H??ng V????ng, H?? N???i', 2, 4, 4, 'tranvansau', 0),
	   (12, 'T??ng Hoang', '1982-09-03', '826231786', 9000000, '0921234121', 'hoang@gmail.com', '213 H??m Nghi, ???? N???ng', 2, 4, 4, 'tranvansau', 0),
	   (13, 'Nguy???n C??ng ?????o', '1994-01-08', '946231786', 4000000, '0971234121', 'dao@gmail.com', '6 Ho?? Kh??nh, ?????ng Nai', 2, 3, 2, 'tranvansau', 0);
       
insert into customer
values (1, 5, 'Nguy???n Th??? H??o', '1970-11-07', 0, '643431213', '0987654321', 'thihao07@gmail.com', '23 Nguy???n Ho??ng, ???? N???ng', 0),
	 (2, 3, 'Ph???m Xu??n Di???u', '1992-08-08', 1, '865342123', '0987654321', 'xuandieu92@gmail.com', 'K77/22 Th??i Phi??n, Qu???ng Tr???', 0),
	 (3, 1, 'Tr????ng ????nh Ngh???', '1990-02-27', 1, '488645199', '0987654321', 'nghenhan2702@gmail.com', 'K323/12 ??ng ??ch Khi??m, Vinh', 0),
	 (4, 1, 'D????ng V??n Quan', '1981-07-08', 1, '634635974', '0987654321', 'duongquan@gmail.com', 'K453/12 L?? L???i, ???? N???ng', 0),
	 (5, 4, 'Ho??ng Tr???n Nhi Nhi', '1995-12-09', 0, '241234757', '0987654321', 'nhinhi123@gmail.com', '224 L?? Th??i T???, Gia Lai', 0),
	 (6, 4, 'T??n N??? M???c Ch??u', '2005-12-06', 0, '956352456', '0987654321', 'tonnuchau@gmail.com', '37 Y??n Th???, ???? N???ng', 0),
	 (7, 1, 'Nguy???n M??? Kim', '1984-04-08', 0, '445682467', '0987654321', 'kimcuong84@gmail.com', 'K123/45 L?? L???i, H??? Ch?? Minh', 0),
	 (8, 3, 'Nguy???n Th??? H??o', '1999-04-08', 0, '456789034', '0987654321', 'haohao99@gmail.com', '55 Nguy???n V??n Linh, Kon Tum', 0),
	 (9, 1, 'Tr???n ?????i Danh', '1994-07-01', 1, '456788956', '0987654321', 'danhhai99@gmail.com', '24 L?? Th?????ng Ki???t, Qu???ng Ng??i', 0),
	 (10, 2, 'Nguy???n T??m ?????c', '1989-07-01', 1, '435678954', '0987654321', 'dactam@gmail.com', '22 Ng?? Quy???n, ???? N???ng', 0);     
     
insert into facility
values (1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'C?? h??? b??i', 500, 4, null, 0),
	   (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'C?? th??m b???p n?????ng', null, 3, null,  0),
	   (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'C?? tivi', null, null, 'N?????c l???c', 0),
	   (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'C?? h??? b??i', 300, 3, null, 0),
	   (5, 'House Princess 02', 10000, 4000000, 5,  3, 2, 'normal', 'C?? th??m b???p n?????ng', null, 2, null, 0),
	   (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'C?? tivi', null, null, 'N?????c l???c', 0);

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

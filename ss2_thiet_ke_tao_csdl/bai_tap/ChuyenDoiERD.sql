create database product_management;
use product_management;

create table nha_cung_cap(
	ma_nha_cung_cap int auto_increment,
    ten_nha_cung_cap varchar(50),
    dia_chi varchar(50),
    primary key(ma_nha_cung_cap)
);

create table so_dien_thoai(
    so_dien_thoai varchar(11),
    ma_nha_cung_cap int,
    primary key(so_dien_thoai),
    foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table don_dat_hang(
	so_don_dat_hang int auto_increment,
    ngay_dat_hang date,
    ma_nha_cung_cap int,
    primary key(so_don_dat_hang),
    foreign key(ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);

create table vat_tu(
	ma_vat_tu int auto_increment,
    ten_vat_tu varchar(50),
    primary key(ma_vat_tu)
);

create table don_dat_hang_cua_vat_tu(
	ma_vat_tu int,
    so_don_dat_hang int,
    primary key(ma_vat_tu, so_don_dat_hang),
    foreign key(ma_vat_tu) references vat_tu(ma_vat_tu),
    foreign key(so_don_dat_hang) references don_dat_hang(so_don_dat_hang)
);

create table phieu_xuat(
	so_phieu_xuat int auto_increment,
    ngay_xuat date,
    primary key(so_phieu_xuat)
);

create table phieu_xuat_cua_vat_tu(
	so_phieu_xuat int,
    ma_vat_tu int,
    dg_xuat float,
    so_luong_xuat int,
    primary key(so_phieu_xuat, ma_vat_tu),
    foreign key(so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
    foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

create table phieu_nhap(
	so_phieu_nhap int auto_increment,
    ngay_nhap date,
    primary key(so_phieu_nhap)
);

create table phieu_nhap_cua_vat_tu(
	so_phieu_nhap int,
    ma_vat_tu int,
    dg_nhap float,
    so_luong_nhap int,
    primary key(so_phieu_nhap, ma_vat_tu),
    foreign key(so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
    foreign key(ma_vat_tu) references vat_tu(ma_vat_tu)
);

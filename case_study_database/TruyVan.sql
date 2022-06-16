use furama_management;

-- yêu cầu 2
select * from nhan_vien
where (ho_ten like 'H%' or ho_ten like 'T%' or ho_ten like 'K%') and (char_length(nhan_vien.ho_ten) <= 15);

-- yêu cầu 3
select * from khach_hang
where ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0) >= 18 and ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0) <=50 
and (dia_chi like "%Đà Nẵng" or dia_chi like "%Quảng Trị");

-- yêu cầu 4
select khach_hang.ma_khach_hang, khach_hang.ho_ten, count(hop_dong.ma_khach_hang) as so_lan_dat_phong 
from khach_hang
join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
where loai_khach.ten_loai_khach = 'Diamond'
group by khach_hang.ma_khach_hang
order by so_lan_dat_phong;
-- yêu cầu 5
select khach_hang.ma_khach_hang, 
khach_hang.ho_ten, 
loai_khach.ten_loai_khach, 
hop_dong.ma_hop_dong, 
dich_vu.ten_dich_vu, 
hop_dong.ngay_lam_hop_dong, 
hop_dong.ngay_ket_thuc,
sum(dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong * dich_vu_di_kem.gia) as 'tong_tien' 
from loai_khach left join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by hop_dong.ma_hop_dong
order by khach_hang.ma_khach_hang;

-- yêu cầu 6
select dich_vu.ma_dich_vu, 
dich_vu.ten_dich_vu, 
dich_vu.dien_tich, 
dich_vu.chi_phi_thue, 
loai_dich_vu.ten_loai_dich_vu from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (month(hop_dong.ngay_lam_hop_dong) between 1 and 3) and (year(hop_dong.ngay_lam_hop_dong) = 2021))
group by hop_dong.ma_dich_vu;

-- yêu cầu 7
select dich_vu.ma_dich_vu, 
dich_vu.ten_dich_vu, 
dich_vu.dien_tich, 
dich_vu.chi_phi_thue, 
loai_dich_vu.ten_loai_dich_vu from dich_vu
join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
join hop_dong on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
where dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where (year(hop_dong.ngay_lam_hop_dong) = 2020))
and dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (year(hop_dong.ngay_lam_hop_dong) = 2021))
group by hop_dong.ma_dich_vu;

 -- yêu cầu 8
select distinct khach_hang.ho_ten from khach_hang;

select khach_hang.ho_ten from khach_hang group by khach_hang.ho_ten;

select khach_hang.ho_ten from khach_hang
union 
select khach_hang.ho_ten from khach_hang;

-- yêu cầu 9
-- select 
-- (select count(*) as thang_1 from hop_dong where month(ngay_lam_hop_dong) = 1) as thang_1,
-- (select count(*) as thang_1 from hop_dong where month(ngay_lam_hop_dong) = 2) as thang_2,
-- (select count(*) as thang_1 from hop_dong where month(ngay_lam_hop_dong) = 3) as thang_3,
-- (select count(*) as thang_1 from hop_dong where month(ngay_lam_hop_dong) = 4) as thang_4
--  from hop_dong;

 select month(ngay_lam_hop_dong) as thang ,count(*) from hop_dong as sl 
 where month(ngay_lam_hop_dong) in(select month(ngay_lam_hop_dong) as t from hop_dong group by t)
 group by month(ngay_lam_hop_dong);
 
 
 
 select * from hop_dong where month(ngay_lam_hop_dong) in(select month(ngay_lam_hop_dong) as t from hop_dong group by t)
 group by month(ngay_lam_hop_dong);
-- yêu cầu 10
select hop_dong.ma_hop_dong,
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc,
hop_dong.tien_dat_coc,
sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as 'so_luong_dich_vu_di_kem' from
hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by hop_dong.ma_hop_dong;

-- yêu cầu 11
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem
from dich_vu_di_kem 
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi like '%Vinh' or khach_hang.dia_chi like '%Quảng Ngãi');

-- yêu cầu 12
select hop_dong.ma_hop_dong, 
nhan_vien.ho_ten, 
khach_hang.ho_ten, 
khach_hang.so_dien_thoai, 
dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, 
sum(ifnull(hop_dong_chi_tiet.so_luong,0)) as 'so_luong_dich_vu_di_kem', 
hop_dong.tien_dat_coc 
from hop_dong
left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
where dich_vu.ma_dich_vu in (select hop_dong.ma_dich_vu from hop_dong where (month(hop_dong.ngay_lam_hop_dong) between 10 and 12) and (year(hop_dong.ngay_lam_hop_dong) = 2020))
and dich_vu.ma_dich_vu not in (select hop_dong.ma_dich_vu from hop_dong where (month(hop_dong.ngay_lam_hop_dong) between 1 and 6) and (year(hop_dong.ngay_lam_hop_dong) = 2021))
group by hop_dong.ma_hop_dong;

-- yêu cầu 13
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as 'so_luong_dich_vu_di_kem'
from dich_vu_di_kem
join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all(select so_luong from hop_dong_chi_tiet);

-- yêu cầu 14
select hop_dong.ma_hop_dong,
loai_dich_vu.ten_loai_dich_vu,
dich_vu_di_kem.ten_dich_vu_di_kem,
count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung 
from hop_dong
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_lan_su_dung = 1;
 
 -- yêu cầu 15
select nhan_vien.ma_nhan_vien, 
nhan_vien.ho_ten, 
trinh_do.ten_trinh_do, 
bo_phan.ten_bo_phan, 
nhan_vien.so_dien_thoai, 
nhan_vien.dia_chi
from nhan_vien
join trinh_do on nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) <=3;

-- yêu cầu 16
SET FOREIGN_KEY_CHECKS = 0;
delete from nhan_vien where ma_nhan_vien in
(select nhan_vien.ma_nhan_vien
from nhan_vien 
left join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where nhan_vien.ma_nhan_vien not in (select hop_dong.ma_nhan_vien from hop_dong where (year(hop_dong.ngay_lam_hop_dong) between 2019 and 2021))
group by nhan_vien.ma_nhan_vien);

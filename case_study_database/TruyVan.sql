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
from loai_khach join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
group by hop_dong.ma_hop_dong
order by khach_hang.ma_khach_hang;

package model;

public class HoKhau {
    private int stt;
    private String ma_ho_khau;
    private String ten_chu_ho;
    private int so_luong_thanh_vien;
    private String ngay_lap_ho_khau;
    private String dia_chi;

    public HoKhau() {
    }

    public HoKhau(int stt, String ma_ho_khau, String ten_chu_ho, int so_luong_thanh_vien, String ngay_lap_ho_khau, String dia_chi) {
        this.stt = stt;
        this.ma_ho_khau = ma_ho_khau;
        this.ten_chu_ho = ten_chu_ho;
        this.so_luong_thanh_vien = so_luong_thanh_vien;
        this.ngay_lap_ho_khau = ngay_lap_ho_khau;
        this.dia_chi = dia_chi;
    }

    public HoKhau(String ma_ho_khau, String ten_chu_ho, int so_luong_thanh_vien, String ngay_lap_ho_khau, String dia_chi) {
        this.ma_ho_khau = ma_ho_khau;
        this.ten_chu_ho = ten_chu_ho;
        this.so_luong_thanh_vien = so_luong_thanh_vien;
        this.ngay_lap_ho_khau = ngay_lap_ho_khau;
        this.dia_chi = dia_chi;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMa_ho_khau() {
        return ma_ho_khau;
    }

    public void setMa_ho_khau(String ma_ho_khau) {
        this.ma_ho_khau = ma_ho_khau;
    }

    public String getTen_chu_ho() {
        return ten_chu_ho;
    }

    public void setTen_chu_ho(String ten_chu_ho) {
        this.ten_chu_ho = ten_chu_ho;
    }

    public int getSo_luong_thanh_vien() {
        return so_luong_thanh_vien;
    }

    public void setSo_luong_thanh_vien(int so_luong_thanh_vien) {
        this.so_luong_thanh_vien = so_luong_thanh_vien;
    }

    public String getNgay_lap_ho_khau() {
        return ngay_lap_ho_khau;
    }

    public void setNgay_lap_ho_khau(String ngay_lap_ho_khau) {
        this.ngay_lap_ho_khau = ngay_lap_ho_khau;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
}

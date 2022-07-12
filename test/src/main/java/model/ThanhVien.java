package model;

public class ThanhVien {
    private String ma_ho_khau;
    private String cmnd;
    private String ho_va_ten;
    private String ngay_sinh;

    public ThanhVien() {
    }

    public ThanhVien(String ma_ho_khau, String cmnd, String ho_va_ten, String ngay_sinh) {
        this.ma_ho_khau = ma_ho_khau;
        this.cmnd = cmnd;
        this.ho_va_ten = ho_va_ten;
        this.ngay_sinh = ngay_sinh;
    }

    public String getMa_ho_khau() {
        return ma_ho_khau;
    }

    public void setMa_ho_khau(String ma_ho_khau) {
        this.ma_ho_khau = ma_ho_khau;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHo_va_ten() {
        return ho_va_ten;
    }

    public void setHo_va_ten(String ho_va_ten) {
        this.ho_va_ten = ho_va_ten;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }
}

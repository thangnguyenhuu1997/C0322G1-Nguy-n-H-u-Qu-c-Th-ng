package service;

import model.HoKhau;

import java.util.List;

public interface IHoKhauService {
    public List<HoKhau> selectAllHoKhau();

    public HoKhau selectHoKhau(int id);

    public void insertHoKhau(HoKhau hoKhau);

    public boolean updateHoKhau(HoKhau hoKhau);
}

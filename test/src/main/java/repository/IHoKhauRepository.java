package repository;

import model.HoKhau;

import java.sql.SQLException;
import java.util.List;

public interface IHoKhauRepository {
    public List<HoKhau> selectAllHoKhau();

    public HoKhau selectHoKhau(int id);

    public void insertHoKhau(HoKhau hoKhau);

    public boolean updateHoKhau(HoKhau hoKhau);
}

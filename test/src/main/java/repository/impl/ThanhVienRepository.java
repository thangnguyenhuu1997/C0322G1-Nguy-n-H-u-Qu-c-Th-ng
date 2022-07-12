package repository.impl;

import model.ThanhVien;
import repository.BaseRepository;
import repository.IThanhVienRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThanhVienRepository implements IThanhVienRepository {
    private final String SELECT_ALL_THANH_VIEN = "SELECT * FROM thanh_vien;";
    @Override
    public List<ThanhVien> selectAllThanhVien() {
        List<ThanhVien> thanhVienList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THANH_VIEN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String ma_ho_khau = resultSet.getString("ma_ho_khau");
                String cmnd = resultSet.getString("cmnd");
                String ho_va_ten = resultSet.getString("ho_va_ten");
                String ngay_sinh = resultSet.getString("ngay_sinh");
                ThanhVien thanhVien = new ThanhVien(ma_ho_khau,cmnd,ho_va_ten,ngay_sinh);
                thanhVienList.add(thanhVien);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return thanhVienList;
    }
}

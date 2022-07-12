package repository.impl;

import model.HoKhau;
import repository.BaseRepository;
import repository.IHoKhauRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoKhauRepository implements IHoKhauRepository {
    private final String SELECT_ALL_HO_KHAU = "SELECT * FROM ho_khau";
    private final String SELECT_HO_KHAU_ID = "SELECT * FROM ho_khau where stt = ?;";
    private final String INSERT_NEW_HO_KHAU = "insert into ho_khau (ma_ho_khau, ten_chu_ho, so_luong_thanh_vien, ngay_lap_ho_khau, dia_chi) values (?,?,?,?,?);";
    private final String UPDATE_HO_KHAU = "update ho_khau set ten_chu_ho =?, ngay_lap_ho_khau=?, dia_chi=? where stt = ?;";

    @Override
    public List<HoKhau> selectAllHoKhau() {
        List<HoKhau> hoKhauList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HO_KHAU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int stt = resultSet.getInt("stt");
                String ma_ho_khau = resultSet.getString("ma_ho_khau");
                String ten_chu_ho = resultSet.getString("ten_chu_ho");
                int so_luong_thanh_vien = resultSet.getInt("so_luong_thanh_vien");
                String ngay_lap_ho_khau = resultSet.getString("ngay_lap_ho_khau");
                String dia_chi = resultSet.getString("dia_chi");
                HoKhau hoKhau = new HoKhau(stt,
                        ma_ho_khau,
                        ten_chu_ho,
                        so_luong_thanh_vien,
                        ngay_lap_ho_khau,
                        dia_chi);
                hoKhauList.add(hoKhau);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hoKhauList;
    }

    @Override
    public HoKhau selectHoKhau(int id) {
        HoKhau hoKhau = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HO_KHAU_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int stt = resultSet.getInt("stt");
                String ma_ho_khau = resultSet.getString("ma_ho_khau");
                String ten_chu_ho = resultSet.getString("ten_chu_ho");
                int so_luong_thanh_vien = resultSet.getInt("so_luong_thanh_vien");
                String ngay_lap_ho_khau = resultSet.getString("ngay_lap_ho_khau");
                String dia_chi = resultSet.getString("dia_chi");
                hoKhau = new HoKhau(stt,
                        ma_ho_khau,
                        ten_chu_ho,
                        so_luong_thanh_vien,
                        ngay_lap_ho_khau,
                        dia_chi);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hoKhau;
    }

    @Override
    public void insertHoKhau(HoKhau hoKhau) {
        System.out.println(INSERT_NEW_HO_KHAU);
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_NEW_HO_KHAU);
            preparedStatement.setString(1, hoKhau.getMa_ho_khau());
            preparedStatement.setString(2, hoKhau.getTen_chu_ho());
            preparedStatement.setInt(3, hoKhau.getSo_luong_thanh_vien());
            preparedStatement.setDate(4, Date.valueOf(hoKhau.getNgay_lap_ho_khau()));
            preparedStatement.setString(5, hoKhau.getDia_chi());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateHoKhau(HoKhau hoKhau) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HO_KHAU);
            preparedStatement.setString(1, hoKhau.getTen_chu_ho());
            preparedStatement.setDate(2, Date.valueOf(hoKhau.getNgay_lap_ho_khau()));
            preparedStatement.setString(3, hoKhau.getDia_chi());
            preparedStatement.setInt(4, hoKhau.getStt());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}

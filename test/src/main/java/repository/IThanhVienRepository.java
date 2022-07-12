package repository;

import model.ThanhVien;

import java.util.List;

public interface IThanhVienRepository {
    List<ThanhVien> selectAllThanhVien();
}

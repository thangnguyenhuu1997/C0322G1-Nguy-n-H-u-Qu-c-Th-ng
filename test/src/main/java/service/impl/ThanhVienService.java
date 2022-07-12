package service.impl;

import model.ThanhVien;
import repository.IThanhVienRepository;
import repository.impl.ThanhVienRepository;
import service.IThanhVienService;

import java.util.List;

public class ThanhVienService implements IThanhVienService {
    private IThanhVienRepository thanhVienRepository = new ThanhVienRepository();
    @Override
    public List<ThanhVien> selectAllThanhVien() {
        return thanhVienRepository.selectAllThanhVien();
    }
}

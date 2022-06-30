package service.employee.impl;

import model.employee.Division;
import repository.employee.IDivisionRepository;
import repository.employee.impl.DivisionRepositoryImpl;
import service.employee.IDivisionService;

import java.util.List;
import java.util.Map;

public class DivisionServiceImpl implements IDivisionService {
    private IDivisionRepository divisionRepository = new DivisionRepositoryImpl();


    @Override
    public List<Division> selectAll() {
        return divisionRepository.selectAll();
    }

    @Override
    public Map<Integer, String> selectDivision() {
        return divisionRepository.selectDivision();
    }
}

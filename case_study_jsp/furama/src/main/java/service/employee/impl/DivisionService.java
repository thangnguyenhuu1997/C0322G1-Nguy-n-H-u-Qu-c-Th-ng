package service.employee.impl;

import model.employee.Division;
import repository.Employee.IDivisionRepository;
import repository.Employee.impl.DivisionRepository;
import service.employee.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository divisionRepository = new DivisionRepository();
    @Override
    public List<Division> selectAllDivision() {
        return divisionRepository.selectAllDivision();
    }
}

package service.impl;

import model.Division;
import repository.DivisionRepository;
import repository.impl.DivisionRepositoryImpl;
import service.DivisionService;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository divisionRepository = new DivisionRepositoryImpl();

    @Override
    public List<Division> selectAllDivision() {
        return divisionRepository.selectAllDivision();
    }
}

package service.facility.impl;

import model.facility.RentType;
import repository.facility.IRentTypeRepository;
import repository.facility.impl.RentTypeRepositoryImpl;
import service.facility.IRentTypeService;

import java.util.List;
import java.util.Map;

public class RentTypeServiceImpl implements IRentTypeService {
    private IRentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();

    @Override
    public List<RentType> selectAll() {
        return rentTypeRepository.selectAll();
    }

    @Override
    public Map<Integer, String> selectRentType() {
        return rentTypeRepository.selectRentType();
    }
}

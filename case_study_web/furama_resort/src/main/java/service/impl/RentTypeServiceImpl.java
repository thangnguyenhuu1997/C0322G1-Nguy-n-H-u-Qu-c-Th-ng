package service.impl;

import model.RentType;
import repository.RentTypeRepository;
import repository.impl.RentTypeRepositoryImpl;
import service.RentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    private RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();

    @Override
    public List<RentType> selectAllRentType() {
        return rentTypeRepository.selectAllRentType();
    }
}

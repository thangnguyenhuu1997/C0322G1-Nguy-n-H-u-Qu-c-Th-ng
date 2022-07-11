package service.impl;

import model.FacilityType;
import repository.FacilityTypeRepository;
import repository.impl.FacilityTypeRepositoryImpl;
import service.FacilityTypeService;

import java.util.List;

public class FacilityTypeServiceImpl implements FacilityTypeService {
    private FacilityTypeRepository facilityTypeRepository = new FacilityTypeRepositoryImpl();

    @Override
    public List<FacilityType> selectAllFacilityType() {
        return facilityTypeRepository.selectAllFacilityType();
    }
}

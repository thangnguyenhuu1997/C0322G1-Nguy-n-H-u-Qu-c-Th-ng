package service.impl;

import model.AttachFacility;
import repository.AttachFacilityRepository;
import repository.impl.AttachFacilityRepositoryImpl;
import service.AttachFacilityService;

import java.util.List;

public class AttachFacilityServiceImpl implements AttachFacilityService {
    private final AttachFacilityRepository attachFacilityRepository = new AttachFacilityRepositoryImpl();

    @Override
    public List<AttachFacility> selectAllAttachFacility() {
        return attachFacilityRepository.selectAllAttachFacility();
    }

    @Override
    public List<AttachFacility> selectAllAttachFacilityContract() {
        return attachFacilityRepository.selectAllAttachFacilityContract();
    }
}

package service.facility.impl;

import model.facility.ServiceType;
import repository.facility.IServiceTypeRepository;
import repository.facility.impl.ServiceTypeRepositoryImpl;
import service.facility.IServiceTypeService;

import java.util.List;
import java.util.Map;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    private IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();

    @Override
    public List<ServiceType> selectAll() {
        return serviceTypeRepository.selectAll();
    }

    @Override
    public Map<Integer, String> selectServiceType() {
        return serviceTypeRepository.selectServiceType();
    }
}

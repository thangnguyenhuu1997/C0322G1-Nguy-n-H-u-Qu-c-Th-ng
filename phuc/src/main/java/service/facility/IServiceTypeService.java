package service.facility;

import model.facility.ServiceType;

import java.util.List;
import java.util.Map;

public interface IServiceTypeService {

    List<ServiceType> selectAll();

    public Map<Integer, String> selectServiceType();

}

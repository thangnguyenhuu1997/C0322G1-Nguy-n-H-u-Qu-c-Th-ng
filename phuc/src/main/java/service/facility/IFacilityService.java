package service.facility;

import model.facility.Facility;

import java.util.List;
import java.util.Map;

public interface IFacilityService {

    public List<Facility> selectAllFacility();

    public Facility selectFacility(int id);

    public Map<String, String> save(Facility facility);

    public Map<String, String> updateFacility(Facility facility);

    public boolean deleteFacility(int id);

    public List<Facility> searchFacility(String keyword);

}

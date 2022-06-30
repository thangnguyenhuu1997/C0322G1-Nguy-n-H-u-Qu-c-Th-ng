package service.facility.impl;

import model.facility.Facility;
import repository.facility.IFacilityRepository;
import repository.facility.impl.FacilityRepositoryImpl;
import service.facility.IFacilityService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class FacilityServiceImpl implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepositoryImpl();
    private final String REGEX_NAME_SERVICE = "^(DV)[-]\\d{4}$";


    @Override
    public List<Facility> selectAllFacility() {
        return facilityRepository.selectAllFacility();
    }

    @Override
    public Facility selectFacility(int id) {
        return null;
    }

    @Override
    public Map<String, String> save(Facility facility) {
        Map<String, String> map = new HashMap<>();
        boolean flag = true;
        if (!Pattern.matches(REGEX_NAME_SERVICE, facility.getServiceName())){
            flag = false;
            map.put("name","Mã dịch vụ phải có dạng DV-XXXX (X là số 0-9)");
        }
        if (facility.getServiceArea() < 0 || facility.getServiceCost() < 0 || facility.getServiceMaxPeople() < 0 ||
                facility.getPoolArea() < 0 || facility.getNumberOfFloor() < 0){
            flag = false;
            map.put("number","Số nhỏ hơn 0, vui lòng nhập số dương");
        }
        if (flag){
            facilityRepository.insertFacility(facility);
        }
        return map;
    }

    @Override
    public Map<String, String> updateFacility(Facility facility) {
        return null;
    }

    @Override
    public boolean deleteFacility(int id) {
        return false;
    }

    @Override
    public List<Facility> searchFacility(String keyword) {
        return null;
    }
}

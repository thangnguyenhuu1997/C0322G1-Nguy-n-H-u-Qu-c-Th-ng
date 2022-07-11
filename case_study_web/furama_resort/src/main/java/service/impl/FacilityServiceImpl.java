package service.impl;

import common.Validate;
import model.Facility;
import model.House;
import model.Room;
import model.Villa;
import repository.FacilityRepository;
import repository.impl.FacilityRepositoryImpl;
import service.FacilityService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityServiceImpl implements FacilityService {
    private final FacilityRepository facilityRepository = new FacilityRepositoryImpl();

    @Override
    public List<Facility> selectAll() {
        return facilityRepository.selectAll();
    }

    @Override
    public List<Facility> selectAllFacility() {
        return facilityRepository.selectAllFacility();
    }

    @Override
    public Facility selectFacility(int id) {
        return facilityRepository.selectFacility(id);
    }

    @Override
    public Map<String, String> insertVilla(Villa villa) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (villa.getName().equals("")) {
            error.put("name", "*Tên không được để trống");
        } else if (!villa.getName().matches(Validate.FACILITY_NAME)) {
            error.put("name", "*Tên dịch vụ không hợp lệ");
        }

        if (String.valueOf(villa.getArea()).equals("")) {
            error.put("area", "*Không được để trống");
        } else if (!String.valueOf(villa.getArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("area", "*Diện tích không hợp lệ");
        }

        if (String.valueOf(villa.getCost()).equals("")) {
            error.put("cost", "*Không được để trống");
        } else if (!String.valueOf(villa.getCost()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("cost", "*Giá không hợp lệ");
        }

        if (String.valueOf(villa.getMaxPeople()).equals("")) {
            error.put("people", "*Không được để trống");
        } else if (!String.valueOf(villa.getMaxPeople()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("people", "*Số người không hợp lệ");
        }

        if (villa.getStandardRoom().equals("")) {
            error.put("standard", "*Không không được để trống");
        }

        if (villa.getOtherDescription().equals("")) {
            error.put("other", "*Không không được để trống");
        }

        if (String.valueOf(villa.getPoolArea()).equals("")) {
            error.put("pool", "*Không được để trống");
        } else if (!String.valueOf(villa.getPoolArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("pool", "*Diện tích hồ bơi người không hợp lệ");
        }

        if (String.valueOf(villa.getNumberFloor()).equals("")) {
            error.put("floor", "*Không được để trống");
        } else if (!String.valueOf(villa.getNumberFloor()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("floor", "*Số tầng người không hợp lệ");
        }

        if (error.isEmpty()) {
            facilityRepository.insertVilla(villa);
        }

        return error;
    }

    @Override
    public Map<String, String> insertHouse(House house) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (house.getName().equals("")) {
            error.put("name", "*Tên không được để trống");
        } else if (!house.getName().matches(Validate.FACILITY_NAME)) {
            error.put("name", "*Tên dịch vụ không hợp lệ");
        }

        if (String.valueOf(house.getArea()).equals("")) {
            error.put("area", "*Không được để trống");
        } else if (!String.valueOf(house.getArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("area", "*Diện tích không hợp lệ");
        }

        if (String.valueOf(house.getCost()).equals("")) {
            error.put("cost", "*Không được để trống");
        } else if (!String.valueOf(house.getCost()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("cost", "*Giá không hợp lệ");
        }

        if (String.valueOf(house.getMaxPeople()).equals("")) {
            error.put("people", "*Không được để trống");
        } else if (!String.valueOf(house.getMaxPeople()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("people", "*Số người không hợp lệ");
        }

        if (house.getStandardRoom().equals("")) {
            error.put("standard", "*Không không được để trống");
        }

        if (house.getOtherDescription().equals("")) {
            error.put("other", "*Không không được để trống");
        }

        if (String.valueOf(house.getNumberFloor()).equals("")) {
            error.put("floor", "*Không được để trống");
        } else if (!String.valueOf(house.getNumberFloor()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("floor", "*Số tầng người không hợp lệ");
        }

        if (error.isEmpty()) {
            facilityRepository.insertHouse(house);
        }

        return error;
    }

    @Override
    public Map<String, String> insertRoom(Room room) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (room.getName().equals("")) {
            error.put("name", "*Tên không được để trống");
        } else if (!room.getName().matches(Validate.FACILITY_NAME)) {
            error.put("name", "*Tên dịch vụ không hợp lệ");
        }

        if (String.valueOf(room.getArea()).equals("")) {
            error.put("area", "*Không được để trống");
        } else if (!String.valueOf(room.getArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("area", "*Diện tích không hợp lệ");
        }

        if (String.valueOf(room.getCost()).equals("")) {
            error.put("cost", "*Không được để trống");
        } else if (!String.valueOf(room.getCost()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("cost", "*Giá không hợp lệ");
        }

        if (String.valueOf(room.getMaxPeople()).equals("")) {
            error.put("people", "*Không được để trống");
        } else if (!String.valueOf(room.getMaxPeople()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("people", "*Số người không hợp lệ");
        }

        if (room.getFacilityFree().equals("")) {
            error.put("free", "*Không không được để trống");
        }

        if (error.isEmpty()) {
            facilityRepository.insertRoom(room);
        }

        return error;
    }

    @Override
    public Map<String, String> updateVilla(Villa villa) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (villa.getName().equals("")) {
            error.put("name", "*Tên không được để trống");
        } else if (!villa.getName().matches(Validate.FACILITY_NAME)) {
            error.put("name", "*Tên dịch vụ không hợp lệ");
        }

        if (String.valueOf(villa.getArea()).equals("")) {
            error.put("area", "*Không được để trống");
        } else if (!String.valueOf(villa.getArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("area", "*Diện tích không hợp lệ");
        }

        if (String.valueOf(villa.getCost()).equals("")) {
            error.put("cost", "*Không được để trống");
        } else if (!String.valueOf(villa.getCost()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("cost", "*Giá không hợp lệ");
        }

        if (String.valueOf(villa.getMaxPeople()).equals("")) {
            error.put("people", "*Không được để trống");
        } else if (!String.valueOf(villa.getMaxPeople()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("people", "*Số người không hợp lệ");
        }

        if (villa.getStandardRoom().equals("")) {
            error.put("standard", "*Không được để trống");
        }

        if (villa.getOtherDescription().equals("")) {
            error.put("other", "*Không được để trống");
        }

        if (String.valueOf(villa.getPoolArea()).equals("")) {
            error.put("pool", "*Không được để trống");
        } else if (!String.valueOf(villa.getPoolArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("pool", "*Diện tích hồ bơi người không hợp lệ");
        }

        if (String.valueOf(villa.getNumberFloor()).equals("")) {
            error.put("floor", "*Không được để trống");
        } else if (!String.valueOf(villa.getNumberFloor()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("floor", "*Số tầng người không hợp lệ");
        }

        if (error.isEmpty()) {
            facilityRepository.insertVilla(villa);
        }

        return error;
    }

    @Override
    public  Map<String, String> updateHouse(House house) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (house.getName().equals("")) {
            error.put("name", "*Tên không được để trống");
        } else if (!house.getName().matches(Validate.FACILITY_NAME)) {
            error.put("name", "*Tên dịch vụ không hợp lệ");
        }

        if (String.valueOf(house.getArea()).equals("")) {
            error.put("area", "*Không được để trống");
        } else if (!String.valueOf(house.getArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("area", "*Diện tích không hợp lệ");
        }

        if (String.valueOf(house.getCost()).equals("")) {
            error.put("cost", "*Không được để trống");
        } else if (!String.valueOf(house.getCost()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("cost", "*Giá không hợp lệ");
        }

        if (String.valueOf(house.getMaxPeople()).equals("")) {
            error.put("people", "*Không được để trống");
        } else if (!String.valueOf(house.getMaxPeople()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("people", "*Số người không hợp lệ");
        }

        if (house.getStandardRoom().equals("")) {
            error.put("standard", "*Không được để trống");
        }

        if (house.getOtherDescription().equals("")) {
            error.put("other", "*Không được để trống");
        }

        if (String.valueOf(house.getNumberFloor()).equals("")) {
            error.put("floor", "*Không được để trống");
        } else if (!String.valueOf(house.getNumberFloor()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("floor", "*Số tầng người không hợp lệ");
        }

        if (error.isEmpty()) {
            facilityRepository.updateHouse(house);
        }

        return error;
    }

    @Override
    public Map<String, String> updateRoom(Room room) throws SQLException {
        Map<String, String> error = new HashMap<>();

        if (room.getName().equals("")) {
            error.put("name", "*Tên không được để trống");
        } else if (!room.getName().matches(Validate.FACILITY_NAME)) {
            error.put("name", "*Tên dịch vụ không hợp lệ");
        }

        if (String.valueOf(room.getArea()).equals("")) {
            error.put("area", "*Không được để trống");
        } else if (!String.valueOf(room.getArea()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("area", "*Diện tích không hợp lệ");
        }

        if (String.valueOf(room.getCost()).equals("")) {
            error.put("cost", "*Không được để trống");
        } else if (!String.valueOf(room.getCost()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("cost", "*Giá không hợp lệ");
        }

        if (String.valueOf(room.getMaxPeople()).equals("")) {
            error.put("people", "*Không được để trống");
        } else if (!String.valueOf(room.getMaxPeople()).matches(Validate.POSITIVE_NUMBER)) {
            error.put("people", "*Số người không hợp lệ");
        }

        if (room.getFacilityFree().equals("")) {
            error.put("free", "*Không không được để trống");
        }

        if (error.isEmpty()) {
            facilityRepository.updateRoom(room);
        }

        return error;
    }

    @Override
    public boolean deleteFacility(int id) throws SQLException {
        return facilityRepository.deleteFacility(id);
    }

    @Override
    public List<Facility> search(String keySearch) {
        return facilityRepository.search(keySearch);
    }
}

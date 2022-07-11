package service;

import model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface FacilityService {
    List<Facility> selectAll();

    List<Facility> selectAllFacility();

    Facility selectFacility(int id);

    Map<String, String> insertVilla(Villa villa) throws SQLException;

    Map<String, String> insertHouse(House house) throws SQLException;

    Map<String, String> insertRoom(Room room) throws SQLException;

    Map<String, String> updateVilla(Villa villa) throws SQLException;

    Map<String, String> updateHouse(House house) throws SQLException;

    Map<String, String> updateRoom(Room room) throws SQLException;

    boolean deleteFacility(int id) throws SQLException;

    List<Facility> search(String keySearch);
}

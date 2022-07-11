package repository;

import model.Facility;
import model.House;
import model.Room;
import model.Villa;

import java.sql.SQLException;
import java.util.List;

public interface FacilityRepository {
    List<Facility> selectAll();

    List<Facility> selectAllFacility();

    Facility selectFacility(int id);

    void insertVilla(Villa villa) throws SQLException;

    void insertHouse(House house) throws SQLException;

    void insertRoom(Room room) throws SQLException;

    boolean updateVilla(Villa villa) throws SQLException;

    boolean updateHouse(House house) throws SQLException;

    boolean updateRoom(Room room) throws SQLException;

    boolean deleteFacility(int id) throws SQLException;

    List<Facility> search(String keySearch);
}

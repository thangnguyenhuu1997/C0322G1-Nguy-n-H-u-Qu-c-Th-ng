package repository.facility;

import model.employee.Employee;
import model.facility.Facility;

import java.sql.SQLException;
import java.util.List;

public interface IFacilityRepository {

    public List<Facility> selectAllFacility();

    public Facility selectEmployee(int id);

    public void insertFacility(Facility facility);

    public boolean updateFacility(Facility facility);

    public boolean deleteFacility(int id);

    public List<Facility> searchFacility(String keyword);

}

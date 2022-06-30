package repository.facility.impl;

import model.facility.Facility;
import repository.BaseRepository;
import repository.facility.IFacilityRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityRepositoryImpl implements IFacilityRepository {
    private final String SELECT_ALL_FACILITY = "SELECT * FROM service;";
    private final String INSERT_NEW_VILLA = "insert into service (service_name," +
                                                                " service_area," +
                                                                " service_cost," +
                                                                " service_max_people," +
                                                                " rent_type_id," +
                                                                " service_type_id," +
                                                                " standard_room," +
                                                                " description_other_convenience," +
                                                                " pool_area," +
                                                                " number_of_floor)" +
                                                                "values (?,?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Facility> selectAllFacility() {
        List<Facility> facilityList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_FACILITY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int serviceId = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floor");
                Facility facility = new Facility(serviceId,
                                                serviceName,
                                                serviceArea,
                                                serviceCost,
                                                serviceMaxPeople,
                                                rentTypeId,
                                                serviceTypeId,
                                                standardRoom,
                                                description,
                                                poolArea,
                                                numberOfFloor);
                facilityList.add(facility);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return facilityList;
    }

    @Override
    public Facility selectEmployee(int id) {
        return null;
    }

    @Override
    public void insertFacility(Facility facility) {
        System.out.println(INSERT_NEW_VILLA);
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_NEW_VILLA);
            ps.setString(1,facility.getServiceName());
            ps.setInt(2,facility.getServiceArea());
            ps.setDouble(3,facility.getServiceCost());
            ps.setInt(4,facility.getServiceMaxPeople());
            ps.setInt(5,facility.getRentTypeId());
            ps.setInt(6,facility.getServiceTypeId());
            ps.setString(7,facility.getStandardRoom());
            ps.setString(8,facility.getDescription());
            ps.setDouble(9,facility.getPoolArea());
            ps.setInt(10,facility.getNumberOfFloor());
            ps.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean updateFacility(Facility facility) {
        return false;
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

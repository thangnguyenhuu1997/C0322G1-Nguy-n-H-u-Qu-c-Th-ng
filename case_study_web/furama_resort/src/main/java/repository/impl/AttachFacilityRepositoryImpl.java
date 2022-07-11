package repository.impl;

import model.AttachFacility;
import repository.AttachFacilityRepository;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachFacilityRepositoryImpl implements AttachFacilityRepository {
    private static final String SELECT_ALL_ATTACH_FACILITY = "select * from attach_facility";
    private static final String SELECT_ALL_ATTACH_FACILITY_CONTRACT = "select attach_facility.* from attach_facility\n" +
            "join contract_detail on attach_facility.attach_facility_id = contract_detail.attach_facility_id\n" +
            "join contract on contract_detail.contract_id = contract.contract_id;";


    @Override
    public List<AttachFacility> selectAllAttachFacility() {
        List<AttachFacility> attachFacilityList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_FACILITY)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("attach_facility_id"));
                String name = rs.getString("attach_facility_name");
                double cost = Double.parseDouble(rs.getString("attach_facility_cost"));
                String unit = rs.getString("attach_facility_unit");
                String status = rs.getString("attach_facility_status");

                attachFacilityList.add(new AttachFacility(id, name, cost, unit, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return attachFacilityList;
    }

    @Override
    public List<AttachFacility> selectAllAttachFacilityContract() {
        List<AttachFacility> attachFacilityContractList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ATTACH_FACILITY_CONTRACT)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("attach_facility_id"));
                String name = rs.getString("attach_facility_name");
                double cost = Double.parseDouble(rs.getString("attach_facility_cost"));
                String unit = rs.getString("attach_facility_unit");
                String status = rs.getString("attach_facility_status");

                attachFacilityContractList.add(new AttachFacility(id, name, cost, unit, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return attachFacilityContractList;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

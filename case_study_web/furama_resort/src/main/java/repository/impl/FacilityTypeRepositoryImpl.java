package repository.impl;

import model.FacilityType;
import repository.BaseRepository;
import repository.FacilityTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityTypeRepositoryImpl implements FacilityTypeRepository {
    private static final String SELECT_ALL_FACILITY_TYPE = "select * from facility_type";

    @Override
    public List<FacilityType> selectAllFacilityType() {
        List<FacilityType> facilityTypeList = new ArrayList<>();

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACILITY_TYPE)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("facility_type_id"));
                String name = rs.getString("facility_type_name");

                facilityTypeList.add(new FacilityType(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return facilityTypeList;
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

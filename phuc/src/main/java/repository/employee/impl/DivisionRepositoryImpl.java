package repository.employee.impl;

import model.employee.Division;
import repository.BaseRepository;
import repository.employee.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DivisionRepositoryImpl implements IDivisionRepository {
    private final String SELECT_DIVISION = "SELECT * FROM division;";


    @Override
    public List<Division> selectAll() {
        List<Division> listDivision = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_DIVISION);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                Division division = new Division(divisionId,divisionName);
                listDivision.add(division);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listDivision;
    }

    @Override
    public Map<Integer, String> selectDivision() {
        Map<Integer, String> map = new HashMap<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_DIVISION);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                map.put(divisionId,divisionName);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return map;
    }
}

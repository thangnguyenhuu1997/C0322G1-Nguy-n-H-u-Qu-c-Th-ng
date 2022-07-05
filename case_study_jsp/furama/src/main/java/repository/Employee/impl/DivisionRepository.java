package repository.Employee.impl;

import model.employee.Division;
import repository.BaseRepository;
import repository.Employee.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private final String SELECT_ALL_DIVISION = "SELECT * FROM division;";
    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int division_id = resultSet.getInt("division_id");
                String division_name = resultSet.getString("division_name");
                Division division = new Division(division_id,division_name);
                divisionList.add(division);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return divisionList;
    }
}

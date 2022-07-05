package repository.Employee.impl;

import model.employee.Position;
import repository.BaseRepository;
import repository.Employee.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private final String SELECT_ALL_POSITION = "SELECT * FROM position;";

    @Override
    public List<Position> selectAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int position_id = resultSet.getInt("position_id");
                String position_name = resultSet.getString("position_name");
                Position position = new Position(position_id, position_name);
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}

package repository.employee.impl;

import model.employee.Position;
import repository.BaseRepository;
import repository.employee.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionRepositoryImpl implements IPositionRepository {
    private final String SELECT_POSITION = "select * from `position`;";


    @Override
    public List<Position> selectAll() {
        List<Position> listPosition = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_POSITION);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                Position position = new Position(positionId,positionName);
                listPosition.add(position);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return listPosition;
    }

    @Override
    public Map<Integer, String> selectPosition() {
        Map<Integer, String> map = new HashMap<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_POSITION);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                map.put(positionId,positionName);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return map;
    }
}

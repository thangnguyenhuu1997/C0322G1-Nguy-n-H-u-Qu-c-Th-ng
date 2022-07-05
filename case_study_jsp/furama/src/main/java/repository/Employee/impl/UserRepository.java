package repository.Employee.impl;


import model.employee.User;
import repository.BaseRepository;
import repository.Employee.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SELECT_ALL_USER = "SELECT * FROM user;";

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                User user = new User(username,password);
                userList.add(user);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return userList;
    }
}

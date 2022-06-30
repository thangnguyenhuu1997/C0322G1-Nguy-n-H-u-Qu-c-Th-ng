package repository.employee.impl;

import model.employee.User;
import repository.BaseRepository;
import repository.employee.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private final String INSERT_USER = "insert into `user` values (?,?);";


    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public void insertUser(User user) {
        System.out.println(INSERT_USER);
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


}

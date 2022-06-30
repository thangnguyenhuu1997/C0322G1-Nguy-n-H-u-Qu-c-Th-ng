package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> selectAllUser();
    public User selectUser (int id);
    public void insertUser(User user) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public boolean deleteUser(int id) throws SQLException;
    public List<User> searchUser(String countrySearch);
}

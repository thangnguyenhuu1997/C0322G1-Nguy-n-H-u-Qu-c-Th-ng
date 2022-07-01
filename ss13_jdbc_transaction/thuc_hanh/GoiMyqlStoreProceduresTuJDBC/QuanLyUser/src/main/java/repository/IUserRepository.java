package repository;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;
}

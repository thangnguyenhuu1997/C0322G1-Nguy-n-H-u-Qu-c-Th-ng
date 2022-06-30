package service;

import model.User;
import repository.IUserRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }

    @Override
    public User selectUser(int id) {
        return userRepository.selectUser(id);
    }

    @Override
    public void insertUser(User user) throws SQLException {
         userRepository.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepository.deleteUser(id);
    }

    @Override
    public List<User> searchUser(String countrySearch) {
        return userRepository.searchUser(countrySearch);
    }
}

package service.employee.impl;

import model.employee.User;
import repository.Employee.IUserRepository;
import repository.Employee.impl.UserRepository;
import service.employee.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> selectAllUser() {
        return userRepository.selectAllUser();
    }
}

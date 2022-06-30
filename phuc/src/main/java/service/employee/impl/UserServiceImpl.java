package service.employee.impl;

import model.employee.User;
import repository.employee.IUserRepository;
import repository.employee.impl.UserRepositoryImpl;
import service.employee.IUserService;

public class UserServiceImpl implements IUserService {
    IUserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

}

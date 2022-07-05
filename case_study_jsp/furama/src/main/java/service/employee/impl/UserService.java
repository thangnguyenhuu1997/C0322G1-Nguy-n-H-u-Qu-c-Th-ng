package service.employee.impl;

import model.employee.User;
import service.employee.IUserService;

import java.util.List;

public class UserService implements IUserService {
    private IUserService userService = new UserService();
    @Override
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }
}

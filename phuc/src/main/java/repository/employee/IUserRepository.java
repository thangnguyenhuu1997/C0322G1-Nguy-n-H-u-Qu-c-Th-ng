package repository.employee;

import model.employee.Employee;
import model.employee.User;

import java.util.List;

public interface IUserRepository {

    public List<User> selectAllUser();

    public void insertUser(User user);

}

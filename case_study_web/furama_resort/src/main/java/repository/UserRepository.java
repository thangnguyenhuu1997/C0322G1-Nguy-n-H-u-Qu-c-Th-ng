package repository;


import model.User;

import java.util.List;

public interface UserRepository {
    List<User> selectAllUser();
}

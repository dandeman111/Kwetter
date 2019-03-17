package DAO;

import java.util.List;
import models.User;

public interface UserDaoInterface {

    boolean create(User user);

    List<User> findAll();

    User find(int id);

    User updateUser(User user);

}

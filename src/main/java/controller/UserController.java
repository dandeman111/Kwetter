package controller;

import DAO.UserDaoInterface;
import java.util.List;
import javax.inject.Inject;
import models.User;

public class UserController {

  @Inject
  UserDaoInterface userDaoInterface;

  public User findUser(int id) {
    return userDaoInterface.find(id);
  }

  public boolean createUser(String name) {
    User user = new User();
    user.setUserName(name);
    return userDaoInterface.create(user);
  }

  public List<User> getAllUsers() {
    return userDaoInterface.findAll();
  }

  public User update(User user) {
    return userDaoInterface.updateUser(user);
  }
}

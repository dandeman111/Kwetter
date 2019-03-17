package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import DAO.UserDaoInterface;
import java.util.ArrayList;
import java.util.List;
import models.Kweet;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

  private String username1 = "testUser";
  private User expectedUser1 = new User(username1);
  private List<Kweet> kweets;

  @Mock UserDaoInterface userDAOMock;

  @InjectMocks UserController userController;

  @Before
  public void setUp() throws Exception {
    User bob = new User();
    bob.setUserName("Bob");
    kweets = new ArrayList<Kweet>();
    kweets.add( new Kweet("test1", bob));
    kweets.add( new Kweet("test1", bob));
    kweets.add( new Kweet("test1", bob));
    bob.setKweets(kweets);
    when(userDAOMock.find(1)).thenReturn(bob);

    when(userDAOMock.findAll())
        .thenReturn(
            new ArrayList<User>() {
              {
                add(new User("bob"));
                add(new User("tim"));
                add(new User("jan"));
              }
            });
  }
  @Test
  public void findAllUsers() {
    Assert.assertEquals("bob", userController.getAllUsers().get(0).getUserName());
    Assert.assertEquals("tim", userController.getAllUsers().get(1).getUserName());
    Assert.assertEquals("jan", userController.getAllUsers().get(2).getUserName());
  }

  @Test
  public void createUser() {
    userController.createUser("bert");
    ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
    verify(userDAOMock).create(argument.capture());
    assertEquals("bert", argument.getValue().getUserName());
  }

  @Test
  public void getKweetsFromUser() {
    List kweetsForUser = userController.findUser(1).getKweets();
    assertEquals(kweets,kweetsForUser);

  }

  @Test
  public void updateUser() {
    User user = userDAOMock.find(1);
    user.setUserName("NotBob");
    userController.update(user);
    User testUser = userDAOMock.find(1);
    assertEquals("NotBob", testUser.getUserName());
  }

}

package boundary.rest;

import controller.UserController;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import models.User;


@Stateless
@Path("user")
public class UserResource {

    @Inject
    UserController userController;

    @GET
    @Path("{id}")
    public User get(@PathParam("id")int id) {
        User user = userController.findUser(id);
        if(user!= null) {
            return user;
        } else {
            return null;
        }
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean create(User user) {
        int id = user.getId();
        return userController.createUser(user.getUserName());
    }

    @GET
    @Path("all")
    public List<User> getAllUsers() {
        return userController.getAllUsers();
    }



}

package boundary.rest;

import controller.KweetController;
import controller.UserController;
import java.util.List;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.MediaType;
import models.Kweet;


@Stateless
@Path("kweet")
public class KweetResource {

    @Inject
    KweetController kweetController;


    @GET
    @Path("{id}")
    public Kweet getKweet(@PathParam("id")int id) {
        return kweetController.getKweetById(id);
    }

    @POST
    @Path("createKweet")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createKweet(Kweet kweet) {
        return kweetController.createKweet(kweet.getText(), kweet.getCreator());
    }

    @POST
    @Path("replyTo/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean reply(Kweet kweet, @PathParam("id") int replyTo) {
        return kweetController.replyToKweet(kweet.getText(),kweet.getCreator().getId(),replyTo);
    }

    @GET
    @Path("kweetsForUser/{userId}")
    public List<Kweet> getKweetsForUser(@PathParam("userId") int userId){
        return kweetController.getKweetsForUser(userId);
    }
}

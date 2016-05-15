package net.hoyoung.resource;

import net.hoyoung.dao.UserDao;
import net.hoyoung.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by hoyoung on 16-5-15.
 */
@Path("/userRes")
public class UserResource {
    UserDao userDao = new UserDao();
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public List<User> getUsers(){
        return userDao.getAllUsers();
    }
}

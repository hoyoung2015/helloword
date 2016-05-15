package net.hoyoung.dao;

import net.hoyoung.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoyoung on 16-5-15.
 */
public class UserDao {
    public List<User> getAllUsers(){
        ArrayList<User> list = new ArrayList<User>();
        for (int i = 1; i <= 3; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name-"+i);
            list.add(user);
        }
        return list;
    }
}

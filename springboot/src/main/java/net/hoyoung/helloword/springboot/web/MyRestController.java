package net.hoyoung.helloword.springboot.web;

import net.hoyoung.helloword.springboot.web.model.Customer;
import net.hoyoung.helloword.springboot.web.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class MyRestController {
    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long user) {
        User u = new User("Lisa");
        u.setUserId(user);
        return u;
    }

    @RequestMapping(value = "/{user}/customers", method = RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable Long user) {
        List<Customer> list = new ArrayList<Customer>();
        list.add(new Customer("zhangsan"));
        list.add(new Customer("lisi"));
        return list;
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user) {
        return new User("hoyoung");
    }
}
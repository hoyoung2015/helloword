package net.hoyoung.helloword.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hoyoung on 16-1-16.
 */
@Controller
public class TestController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "test";
    }
}

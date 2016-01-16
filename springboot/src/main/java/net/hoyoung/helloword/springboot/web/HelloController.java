package net.hoyoung.helloword.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PreDestroy;
import java.util.Set;

/**
 * Created by hoyoung on 16-1-15.
 */
@Controller
public class HelloController {
    /**
     * 注入application.properties中的参数
     */
    @Value("${speed}")
    private int speed;

    @Autowired
    private ConnectionSettings connectionSettings;



    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println(connectionSettings.toString());
        return "哈喽，Spring Boot ！我加的,speed="+speed;
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("HelloController PreDestroy");
    }
}

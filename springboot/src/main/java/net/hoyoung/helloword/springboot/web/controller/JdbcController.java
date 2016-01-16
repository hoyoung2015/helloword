package net.hoyoung.helloword.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hoyoung on 16-1-16.
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/add")
    public String add(){

        int result = jdbcTemplate.update("insert into user(name) VALUES(?)", new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,"hoyoung");
            }
        });
        return "successful:"+result;
    }
}

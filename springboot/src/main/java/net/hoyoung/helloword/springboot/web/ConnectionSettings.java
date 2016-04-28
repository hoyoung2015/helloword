package net.hoyoung.helloword.springboot.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hoyoung on 16-1-16.
 */
@Component
@ConfigurationProperties(prefix = "connection")
public class ConnectionSettings {
    /**
     * 注意必须有setter
     */
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConnectionSettings{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

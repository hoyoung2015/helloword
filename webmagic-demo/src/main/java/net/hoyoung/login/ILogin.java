package net.hoyoung.login;

import org.apache.http.cookie.Cookie;

import java.io.IOException;
import java.util.List;

/**
 * Created by hoyoung on 16-3-31.
 */
public interface ILogin {
    public List<Cookie> doLogin(String username,String password) throws IOException;
}

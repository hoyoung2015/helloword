package net.hoyoung.helloword.springboot.web.model;

/**
 * Created by hoyoung on 16-1-16.
 */
public class User {
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private long userId;
    private String name;
    private String intro;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

}

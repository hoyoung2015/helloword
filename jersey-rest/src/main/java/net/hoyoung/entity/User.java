package net.hoyoung.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by hoyoung on 16-5-15.
 */
@XmlRootElement
public class User implements Serializable{

    private int id;

    private String name;
    @XmlElement //这个注解必须加到getter方法上
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

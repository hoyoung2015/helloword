package net.hoyoung.helloword.springboot.web.model;

/**
 * Created by hoyoung on 16-1-16.
 */
public class Customer {
    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    private long customerId;
    private String name;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package net.hoyoung.factory_method;

/**
 * Created by hoyoung on 16-4-21.
 */
public class ConcreteProductB implements Product {
    public void method() {
        System.out.println(this.getClass().getName());
    }
}

package net.hoyoung.simple_factory;

/**
 * Created by hoyoung on 16-4-21.
 */
public class ConcreteProductB extends Product {
    @Override
    public void methodDiff() {
        System.out.println(this.getClass().getName());
    }
}

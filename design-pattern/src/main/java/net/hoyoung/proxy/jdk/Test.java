package net.hoyoung.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by hoyoung on 16-3-8.
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        TimeInvokeHandler timeInvokeHandler = new TimeInvokeHandler(car);
        Class<?> inter = car.getClass();
        Moveable moveable = (Moveable)Proxy.newProxyInstance(car.getClass().getClassLoader(),car.getClass().getInterfaces(),timeInvokeHandler);
        moveable.move();
    }
}

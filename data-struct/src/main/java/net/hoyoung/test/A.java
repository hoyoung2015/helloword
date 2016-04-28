package net.hoyoung.test;

/**
 * Created by hoyoung on 16-3-26.
 */
public class A {
    static {
        System.out.println("Load A");
    }
    {
        System.out.println("block A");
    }
    public A() {
        System.out.println("Create A");
    }
    static {
        System.out.println("Load A under constructor");
    }
}

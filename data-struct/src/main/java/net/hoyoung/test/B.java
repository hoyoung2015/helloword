package net.hoyoung.test;

/**
 * Created by hoyoung on 16-3-26.
 */
public class B extends A {
    static {
        System.out.println("Load B");
    }
    {
        System.out.println("block B");
    }

    public B() {
        System.out.println("create B");
    }

    public static void main(String[] args) {
        new B();
    }
}

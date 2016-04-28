package net.hoyoung.test;

/**
 * Created by hoyoung on 16-3-26.
 */
public class C {
    public C() {
        System.out.println("constructor");
    }
    public void C(){
        System.out.println("c");
    }

    public static void main(String[] args) {
        C c = new C();
        c.C();
    }
}

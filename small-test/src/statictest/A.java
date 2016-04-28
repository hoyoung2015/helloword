package statictest;

/**
 * Created by hoyoung on 16-4-27.
 */
public class A {
    public static void main(String[] args) {
        B.funB();
        B b = new B();
        b.funB();

        b.funA();

        A a = b;
        a.funA();
    }
    public static void funA(){
        System.out.println("funA");
    }
}
class B extends A{
    /**
     * 静态方法不会被重写
     */
    public static void funA(){
        System.out.println("B override funA");
    }
    public static void funB(){
        System.out.println("funB");
    }
}
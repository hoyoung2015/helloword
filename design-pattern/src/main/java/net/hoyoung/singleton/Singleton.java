package net.hoyoung.singleton;

/**
 * Created by hoyoung on 16-3-7.
 * 双锁检查
 */
public class Singleton {
    private static volatile Singleton instance;
    public static Singleton getInstance(){
        /**
         * 此处判空不用加锁,否则影响性能
         * 只有未实例化的时候才加锁
         */
        if(instance==null){
            synchronized (Singleton.class){
                /**
                 * 这里进行第二次检查,这个检查是在加锁之后的
                 * A,B两个线程,如果A正在实例化但是没有完成,此时instance是空的,B等待这个锁,当A实例化完成后释放
                 * 锁,B拿到锁,但是instance已经初始化过了,所以还要进行一次检查
                 */
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by hoyoung on 16-4-28.
 * 死锁示例
 * A,B两个线程,交叉争用两把锁lock1和lock2
 */
public class DeadLockDemo {
    static class RunnableImpl implements Runnable{
        Object lock1;
        Object lock2;

        public RunnableImpl(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock1){
                System.out.println(Thread.currentThread()+" get lock1");
                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread()+" get lock2");
                }
            }
        }
    }
    static class RunnableImpl2 implements Runnable{
        Object lock1;
        Object lock2;

        public RunnableImpl2(Object lock1, Object lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock2){
                System.out.println(Thread.currentThread()+" get lock2");
                synchronized (lock1){
                    System.out.println(Thread.currentThread()+" get lock1");
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread t1 = new Thread(new RunnableImpl(lock1,lock2));
        Thread t2 = new Thread(new RunnableImpl2(lock1,lock2));
        t1.start();
        t2.start();
    }
}

package thread.wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by hoyoung on 16-4-28.
 */
public class WaitDemo {
    static Object lock = new Object();
    static class Waiter extends Thread{
        @Override
        public void run() {
                synchronized(lock){
                    System.out.println(Thread.currentThread() + "wait");
                    /**
                     * wait()必须在获得锁之后调用,否则报IllegalMonitorStateException异常
                     * 调用wait会释放锁
                     */

                    try {
                        lock.wait();
                        System.out.println(Thread.currentThread()+"wait被唤醒了");
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread() + "被interrupt,是否持有lock:"+Thread.holdsLock(lock));
                    }


//                    System.out.println(Thread.holdsLock(lock));
                }

            System.out.println(Thread.currentThread()+"执行完毕");
        }
    }

    public static void main(String[] args) {


        Waiter t1 = new Waiter();
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock){
//            t1.interrupt();//在此处打断,则下面的notify无效
            System.out.println(Thread.currentThread()+"获得了lock");
            System.out.println(Thread.currentThread()+"要叫醒t1");
            /**
             * notify()和wait()一样必须在获得锁之后调用,否则报IllegalMonitorStateException异常
             * notify会等到同步快执行完了才叫醒等待在这个锁上的线程
             */
            lock.notify();
//            t1.interrupt();//在此处打断,则不会触发t1的InterruptedException
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()+"同步块执行完了");
        }

    }
}

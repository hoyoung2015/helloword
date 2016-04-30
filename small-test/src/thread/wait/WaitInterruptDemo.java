package thread.wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by hoyoung on 16-4-28.
 */
public class WaitInterruptDemo {
    static Object lock = new Object();
    static class Waiter extends Thread{
        @Override
        public void run() {
            try {
                synchronized(lock){
                    /**
                     * wait()必须在获得锁之后调用,否则报IllegalMonitorStateException异常
                     * 调用wait会释放锁
                     */
                    lock.wait();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread() + "被interrupt");
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
        t1.interrupt();

    }
}

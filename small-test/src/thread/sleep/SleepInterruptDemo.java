package thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * Created by hoyoung on 16-4-28.
 */
public class SleepInterruptDemo {
    static class Sleeper implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread()+"sleep了");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread()+"被interrupt");
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Sleeper());
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}

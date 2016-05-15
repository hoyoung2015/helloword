package concurrent;

import java.util.concurrent.*;

/**
 * Created by hoyoung on 16-5-2.
 * 多个线程等待某一事件发生继续往下实行
 * 使用闭锁实现
 */
public class MultiThreadWaitEventLatch {
    static class Worker implements Runnable{


        CountDownLatch latch;
        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start run");
            if(latch!=null){
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" over");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            pool.execute(new Worker(latch));
        }
        pool.shutdown();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" go here");
        for (int i = 0; i < 3; i++) {
            latch.countDown();
        }
    }
}

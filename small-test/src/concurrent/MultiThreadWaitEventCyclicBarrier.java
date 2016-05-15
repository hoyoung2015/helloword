package concurrent;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * Created by hoyoung on 16-5-2.
 * 多个线程等待某一事件发生继续往下实行
 * 使用栅栏 实现
 */
public class MultiThreadWaitEventCyclicBarrier {
    static class Worker implements Runnable{


        CyclicBarrier cyclicBarrier;
        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start run");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" over");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            /**
             * 计数器变为0后,执行这个线程
             */
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" go here");
            }
        });

        for (int i = 0; i < 3; i++) {
            pool.execute(new Worker(cyclicBarrier));
        }
        pool.shutdown();
    }
}

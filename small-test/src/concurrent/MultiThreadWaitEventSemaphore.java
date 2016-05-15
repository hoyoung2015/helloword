package concurrent;

import java.util.concurrent.*;

/**
 * Created by hoyoung on 16-5-2.
 * 多个线程等待某一事件发生继续往下实行
 * 使用信号量实现
 */
public class MultiThreadWaitEventSemaphore {
    static class Worker implements Runnable{


        Semaphore semaphore;
        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " start run");
            if(semaphore!=null){
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" over");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);

        try {
            for (int i = 0; i < 3; i++) {
                semaphore.acquire();//一开始将信号量用完
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            pool.execute(new Worker(semaphore));
        }
        pool.shutdown();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" go here");
        for (int i = 0; i < 3; i++) {
            semaphore.release();
        }
    }
}

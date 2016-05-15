package concurrent;

import java.util.concurrent.*;

/**
 * Created by hoyoung on 16-5-2.
 * 多个线程等待某一事件发生继续往下实行
 * 使用阻塞队列实现
 */
public class MultiThreadWaitEventBlockingQueue {
    static class Worker implements Runnable{

        BlockingQueue queue;
        public Worker(BlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" start run");
            if(queue!=null){
                try {
                    queue.take();//注意使用阻塞的take
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+" over");
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        BlockingQueue queue = new LinkedBlockingDeque();
        for (int i = 0; i < 3; i++) {
            pool.execute(new Worker(queue));
        }
        pool.shutdown();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" go here");
        for (int i = 0; i < 3; i++) {
            try {
                queue.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

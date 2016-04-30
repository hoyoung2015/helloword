package thread.call_able;

import java.util.concurrent.*;

/**
 * Created by hoyoung on 16-4-28.
 */
public class CallableDemo {
    static class CallableImpl implements Callable<String>{
        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(1);
            return Math.random()+"";
        }
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(new CallableImpl());
        try {
            String result = future.get();//这里会阻塞
//            String result = future.get(10,TimeUnit.SECONDS);//超时等待
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();


    }
}

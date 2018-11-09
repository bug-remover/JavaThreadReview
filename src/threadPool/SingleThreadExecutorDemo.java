package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION:TODO <br/>
 *
 * @author qizhongju
 * @Date: 2018/11/8 20:22  <br/>
 */
public class SingleThreadExecutorDemo {

    public static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("time：" + System.currentTimeMillis() + "  Thread Id：" + Thread.currentThread().getId());
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CacheThreadPoolDemo.Task task = new CacheThreadPoolDemo.Task();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }

    /**
     *   输出：
     time：1541679798669  Thread Id：11
     time：1541679800670  Thread Id：11
     time：1541679802671  Thread Id：11
     time：1541679804671  Thread Id：11
     time：1541679806672  Thread Id：11
     time：1541679808672  Thread Id：11
     time：1541679810673  Thread Id：11
     time：1541679812673  Thread Id：11
     time：1541679814673  Thread Id：11
     time：1541679816673  Thread Id：11
     */

}

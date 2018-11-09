package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION:TODO <br/>
 *
 * @author qizhongju
 * @Date: 2018/11/8 20:19  <br/>
 */
public class CacheThreadPoolDemo {

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
        Task task = new Task();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
    }

    /**
     *   输出：
     time：1541679672219  Thread Id：11
     time：1541679672219  Thread Id：12
     time：1541679672219  Thread Id：13
     time：1541679672220  Thread Id：14
     time：1541679672220  Thread Id：15
     time：1541679672220  Thread Id：16
     time：1541679672220  Thread Id：17
     time：1541679672220  Thread Id：18
     time：1541679672220  Thread Id：19
     time：1541679672220  Thread Id：20
     */

}

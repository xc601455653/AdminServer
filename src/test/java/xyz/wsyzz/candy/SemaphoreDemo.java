package xyz.wsyzz.candy;

import java.util.concurrent.Semaphore;

/**
 * Created by xucan on 2022/3/19.
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        semaphore.acquire();
                        System.out.println("获取令牌成功" + ii);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                        System.out.println("释放令牌成功" + ii);
                    }

                }
            }).start();
        }

    }
}

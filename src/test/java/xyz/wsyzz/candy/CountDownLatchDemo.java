package xyz.wsyzz.candy;

import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by xucan on 2022/3/19.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            final int ii = i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println("==========" + ii);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("四个线程已经执行完了");
    }

    class DemoTask {

    }

}

package xyz.wsyzz.candy;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by xucan on 2022/3/19.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行完了");
            }
        });
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ii);
                    try {
                        cyclicBarrier.await(1, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        cyclicBarrier.reset();
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}

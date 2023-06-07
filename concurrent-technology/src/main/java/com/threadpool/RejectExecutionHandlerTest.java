package com.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的拒绝策略
 */
public class RejectExecutionHandlerTest {

    /**
     * 线程池无法接受，就直接退出
     */
    private static final ThreadPoolExecutor abortPolicyThreadPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());
    /**
     * 线程池无法接受，就使用提交任务的线程执行这个任务
     */
    private static final ThreadPoolExecutor callerRunsPolicyThreadPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.CallerRunsPolicy());
    /**
     * 线程池无法接受，直接丢弃，不做任何事情
     */
    private static final ThreadPoolExecutor discardPolicyThreadPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardPolicy());
    /**
     * 线程池无法接受，直接丢弃，不做任何事情
     */
    private static final ThreadPoolExecutor discardOldestPolicyThreadPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            int finalI = i;
            discardOldestPolicyThreadPool.execute(()->{
                try {
                    System.out.println(Thread.currentThread()+"，开始执行！"+ finalI);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("结束!");
        discardOldestPolicyThreadPool.shutdown();
    }

}

package com.zghw.imitate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhanghongwei on 2017/6/18.
 */
public class CountableThreadPool {
    private ExecutorService executorService;
    private int threadNum;

    public CountableThreadPool(int threadNum) {
        this(threadNum, Executors.newFixedThreadPool(threadNum));
    }

    public CountableThreadPool(int threadNum, ExecutorService executorService) {
        this.threadNum = threadNum;
        this.executorService = executorService;

    }

    public void execute(Runnable command) {
        executorService.execute(command);
    }

    public void shutdown() {
        executorService.shutdown();

    }

    public boolean isShutdown() {
        return executorService.isShutdown();
    }
}

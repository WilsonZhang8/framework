package com.zghw.imitate;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhanghongwei on 2017/6/18.
 */
//实现Runnable接口
public class MultiThreadPool implements Runnable {
    private static final int STAT_INIT = 0;//线程初始化标志
    private static final int STAT_RUNNING = 1;//线程运行中标志
    private static final int STAT_STOP = 2;//线程停止标志
    private AtomicInteger stat = new AtomicInteger(STAT_INIT);//记录线程生命周期状态,使用原子类型来标志保证线程安全
    private boolean destroyWhenExit = true;//线程停止后是否销毁资源后退出.
    private ExecutorService executorService;
    private CountableThreadPool threadPool;
    private int threadNum = 1;
    private static AtomicInteger count = new AtomicInteger(0);

    public MultiThreadPool() {
    }

    public void run() {
        System.out.println("entry run()");
        checkRunningStat();
        initComponent();
        //当线程没有被打断,并且一直运行
        while (!Thread.currentThread().isInterrupted() && stat.get() == STAT_RUNNING) {
            final int c = count.decrementAndGet();
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("count =" + c);
                    if (c > 1000) {
                        try {
                            throw new InterruptedException("have enjoy");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        //线程结束标志设置
        stat.set(STAT_STOP);
        if (destroyWhenExit) {
            close();
        }
    }

    /**
     * 初始化组件
     */
    private void initComponent() {
        if (threadPool == null || threadPool.isShutdown()) {
            if (executorService != null && !executorService.isShutdown()) {
                threadPool = new CountableThreadPool(threadNum, executorService);
            } else {
                threadPool = new CountableThreadPool(threadNum);
            }
        }
    }

    public void start() {
        runAsync();
    }

    public void runAsync() {
        Thread thread = new Thread(this);
        //设置非守护线程
        thread.setDaemon(false);
        thread.start();
    }

    public void stop() {
        if (stat.compareAndSet(STAT_RUNNING, STAT_STOP)) {
            System.out.println("MultiThreadLifeCycle stopped!");
        } else {
            System.out.println("MultiThreadLifeCycle stop fail!");
        }
    }


    public void close() {
        //设置需要销毁的对象
        destroyEachObject(new Object());
        threadPool.shutdown();
    }

    //关闭对象资源
    private void destroyEachObject(Object object) {
        if (object instanceof Closeable) {
            try {
                ((Closeable) object).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //得到运行状态
    public Status getStatus() {
        return Status.fromValue(stat.get());
    }

    public enum Status {
        INIT(0), RUNNING(1), STOP(2);
        private int value;

        private Status(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        public static Status fromValue(int value) {
            for (Status status : Status.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            //default value
            return INIT;
        }
    }

    /**
     * 检查运行状态
     */
    private void checkRunningStat() {
        System.out.println("check Running state");
        while (true) {
            int currentStat = stat.get();
            //如果运行已经运行则抛出信息
            if (currentStat == STAT_RUNNING) {
                throw new IllegalStateException("MultiThreadLifeCycle have started!");
            }
            if (stat.compareAndSet(currentStat, STAT_RUNNING)) {
                //设置当前线程状态标志为启动
                break;
            }
        }
    }

    /**
     * 设置线程池服务
     *
     * @param executorService
     * @return
     */
    public MultiThreadPool setExecutorService(ExecutorService executorService) {
        checkIfRunning();
        this.executorService = executorService;
        return this;
    }

    /**
     * 设置线程数量
     *
     * @param num
     * @return
     */
    public MultiThreadPool setThread(int num) {
        if (num < 0) {
            System.out.println("thread num least then one");
        }
        this.threadNum = num;
        return this;
    }

    /**
     * 验证是否正在运行
     */
    private void checkIfRunning() {
        if (stat.get() == STAT_RUNNING) {
            throw new IllegalStateException("MultiThread is running!!");
        }
    }

    public static void main(String args[]) {
        MultiThreadPool thread = new MultiThreadPool();
        thread.run();
    }
}

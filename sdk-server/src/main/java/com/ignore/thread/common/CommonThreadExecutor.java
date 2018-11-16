package com.ignore.thread.common;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: ignore1992
 * @Description: 提供给内部服务自定义线程池
 * @Date: Created In 14:31 2018/11/16
 */
public class CommonThreadExecutor extends ThreadPoolExecutor {

    public CommonThreadExecutor(int corePoolSize , int maxPoolSize , int keepAliveTime , String threadName) {
        super(corePoolSize , maxPoolSize , keepAliveTime , TimeUnit.MILLISECONDS , new SynchronousQueue<>() , new InnerThreadFactory(threadName));
    }

    private static class InnerThreadFactory implements ThreadFactory {
        private static final AtomicLong POOL_NUMBER = new AtomicLong(0);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public InnerThreadFactory(String threadName) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (StringUtils.isBlank(threadName)) {
                threadName = "common";
            }
            namePrefix = threadName + POOL_NUMBER.get() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group , r , namePrefix + threadNumber.getAndIncrement() , 0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}

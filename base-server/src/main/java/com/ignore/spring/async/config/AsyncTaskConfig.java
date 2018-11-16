package com.ignore.spring.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: ignore1992
 * @Description: 这是配置spring异步任务线程池的一种实现，AsyncHandlerService也是一种实现
 * @Date: Created In 10:33 2018/9/11
 * @Modified By:
 */
@EnableAsync
@Configuration
public class AsyncTaskConfig {
    /**
     * 实现Spring多线程bean配置
     *
     * @return
     */
    @Bean
    public ThreadPoolTaskExecutor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        //设置线程池中线程空闲时保活时间
        //当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
        //如果allowCoreThreadTimeout=true，则会直到线程数量=0
        executor.setKeepAliveSeconds(30);
        //设置阻塞队列的大小，当queueCapacity>0时，spring使用LinkedBlockingQueue，否则使用SynchronousQueue(不排队直接创建线程处理)
        //默认大小为2147483647，即默认使用LinkedBlockingQueue
        executor.setQueueCapacity(1000);
        //设置拒绝策略：AbortPolicy、CallerRunsPolicy、DiscardPolicy、DiscardOldestPolicy四种策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //设置线程池优先级
        executor.setThreadPriority(Thread.NORM_PRIORITY);
        //是否允许核心线程池超时关闭
        executor.setAllowCoreThreadTimeOut(false);
        //装饰者方式，可以用来包装任务命令
        executor.setTaskDecorator(null);
        //设置等待超时时间，如果设置>0，则会调用executor.awaitTermination()方法
        //awaitTermination()方法会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false
        //spring中是在调用shutdown方法后调用该方法,如果在设置的时间内线程池没有关闭，则提示:Timed out while waiting for executor
        executor.setAwaitTerminationSeconds(10);
        //设置线程名称前缀
        executor.setThreadNamePrefix("test");
        //设置线程组
        executor.setThreadGroup(new ThreadGroup("test-group"));
        //设置线程组名称，内部其实是根据该线程组名称new了一个ThreadGroup，将上一步的操作覆盖了
        executor.setThreadGroupName("test-group");
        //设置是否等待已提交的任务执行完成再关闭线程池
        //如果设置为true，则调用shutdown方法，会执行完已经提交的所有任务
        //如果设置为false，则调用shutdownNow方法，会关闭正在执行和等待的任务
        //默认为false
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //设置创建线程的工厂，一般默认使用Excutors中内部类DefaultThreadFactory
        //但是Spring自己实现了ThreadFactory,即CustomizableThreadFactory，这是Spring线程池的默认使用工厂
        executor.setThreadFactory(null);
        //beanName会将ThreadNamePrefix覆盖
        executor.setBeanName("test-beanName");
        return executor;
    }
}

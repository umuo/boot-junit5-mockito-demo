package cn.lacknb.blog.bootjunit5mockitodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * Thread pool configuration for async operations
 * @author gitsilence
 */
@Configuration
public class ThreadPoolConfig {

    /**
     * Custom thread pool bean for async operations
     * Core pool size: 5
     * Max pool size: 10
     * Queue capacity: 25
     * Thread name prefix: Custom-Async-
     * Rejection policy: CallerRunsPolicy
     */
    @Bean("customThreadPool")
    public ThreadPoolExecutor customThreadPool() {
        return new ThreadPoolExecutor(
                5, 10, 120, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()
        );
    }

    @Bean
    public ExecutorService myExecutorService() {
        return Executors.newFixedThreadPool(5);
    }
}
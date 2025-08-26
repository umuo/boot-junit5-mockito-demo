package cn.lacknb.blog.bootjunit5mockitodemo.service;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Async service demonstrating CompletableFuture.runAsync with custom thread pool
 * @author gitsilence
 */
@Service
public class AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Resource(name = "customThreadPool")
    private ThreadPoolExecutor customThreadPool;

    /**
     * Business method that uses CompletableFuture.runAsync with custom thread pool
     * @param taskName the name of the task to execute
     * @return CompletableFuture<Void> for the async operation
     */
    public CompletableFuture<Void> executeAsyncTask(String taskName) {
        logger.info("Starting async task: {}", taskName);
        // try {
        //     TimeUnit.SECONDS.sleep(20);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        logger.info("睡眠结束~");
        return CompletableFuture.runAsync(() -> {
            try {
                // Simulate some work
                Thread.sleep(1000);
                logger.info("Executing task: {} on thread: {}", taskName, Thread.currentThread().getName());
                
                // Simulate business logic
                String result = processTask(taskName);
                logger.info("Task completed: {} with result: {}", taskName, result);
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Task interrupted: {}", taskName, e);
                throw new RuntimeException("Task interrupted: " + taskName, e);
            }
        }, customThreadPool);
    }

    /**
     * Business method that executes async task and waits for completion
     * @param taskName the name of the task to execute
     */
    public void executeAndWaitForCompletion(String taskName) {
        logger.info("Starting task and waiting for completion: {}", taskName);
        CompletableFuture<Void> future = executeAsyncTask(taskName);

        logger.info("Waiting for task to complete: {}", taskName);
        // Wait for completion
        future.join();
        
        logger.info("Task completed and joined: {}", taskName);
    }

    /**
     * Simulate business logic processing
     * @param taskName the task name to process
     * @return processing result
     */
    private String processTask(String taskName) {
        // Simulate some business logic
        return "Processed-" + taskName + "-" + System.currentTimeMillis();
    }

    public void submitTask(String taskName) {
        logger.info("Starting task: {}", taskName);
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeTask(String taskName) {
        logger.info("Starting task: {}", taskName);
        int count = 1;
        while (true) {
            try {
                logger.info("Task is running: {}, count => {}", taskName, count++);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
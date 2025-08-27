package cn.lacknb.blog.bootjunit5mockitodemo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Unit test for AsyncService demonstrating Mockito and JUnit 5 features
 */
@ExtendWith(MockitoExtension.class)
// @RunWith(MockitoJUnitRunner.class)
@Slf4j
public class AsyncServiceTest {

    @InjectMocks
    private AsyncService asyncService;

    @Mock
    private ThreadPoolExecutor customThreadPool;

    @Mock
    private ExecutorService executorService;

    @Test
    @DisplayName("测试阻塞任务")
    @Disabled
    // @Timeout(5) // 5秒超时
    void testCustomThreadPoolCreation() {
        asyncService.executeAndWaitForCompletion("测试阻塞任务");
    }

    @Test
    @DisplayName("测试非阻塞任务")
    @Timeout(3)
    @Disabled
    void test_SubmitTask() {
        asyncService.submitTask("测试非阻塞任务");
    }

    @Test
    @DisplayName("测试普通任务")
    void  test_T_NormalTask() {
        log.info("该任务已正常执行~");
    }

    @Test
    @DisplayName("测试循环任务(有休眠)")
    // @Disabled
    // @Timeout(3) // 10秒超时
    void testLoopTask() {
        asyncService.executeTask("测试循环任务(有休眠)");
    }

    /**
     * 线程一直处于 Runnable 状态，无法 被中断
     */
    @Test
    @DisplayName("测试循环任务(无休眠)")
    @Timeout(3)
    // @Disabled
    void testLoopTask_withNoSleep() {
        asyncService.executeTaskWithNoSleep("测试循环任务(无休眠)");
    }

    // @org.junit.Test(timeout = 3000)
    @Test
    @DisplayName("测试FutureJoin")
    @Timeout(3)
    @Disabled
   public void testLoopTask_futureJoin() {
        log.info("测试FutureJoin");
        asyncService.futureJoin();
    }

    @Test
    void printPid() {
        System.out.println("Forked JVM PID = " + ProcessHandle.current().pid());
    }
}
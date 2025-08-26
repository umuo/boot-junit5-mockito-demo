package cn.lacknb.blog.bootjunit5mockitodemo.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Unit test for AsyncService demonstrating Mockito and JUnit 5 features
 */
@ExtendWith(MockitoExtension.class)
class AsyncServiceTest {

    @InjectMocks
    private AsyncService asyncService;

    @Mock
    private ThreadPoolExecutor customThreadPool;

    @Test
    @DisplayName("测试阻塞任务")
    // @Disabled
    // @Timeout(5) // 5秒超时
    void testCustomThreadPoolCreation() {
        asyncService.executeAndWaitForCompletion("测试阻塞任务");
    }

    @Test
    @DisplayName("测试非阻塞任务")
    void testSubmitTask() {
        asyncService.submitTask("测试非阻塞任务");
    }

    @Test
    @DisplayName("测试循环任务")
    void testLoopTask() {
        asyncService.executeTask("测试循环任务");
    }

}
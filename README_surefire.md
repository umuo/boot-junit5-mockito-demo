
# Surefire 配置相关

## 一些超时的参数

- forkedProcessExitTimeoutInSeconds
当测试执行完成后，如果测试代码启动了非守护线程（non-daemon threads），forked JVM 进程可能无法正常通过 System.exit() 退出，而是会一直挂起

forkedProcessExitTimeoutInSeconds 参数用于控制测试执行完成后，JVM 进程退出的超时时间。

当单测代码执行过程中启动了异步线程（非守护线程），测试主逻辑执行完毕后，这些异步线程可能仍在运行。 IntegrationTestMojo.java:175-179 由于 JVM 的特性，只要存在活跃的非守护线程，整个 JVM 进程就无法正常退出，即使调用了 System.exit()。这个参数设置的是测试完成后，等待 JVM 进程自然退出的最大时间。 ForkedBooter.java:141 如果在指定时间内进程仍未退出（因为非守护线程仍在运行），系统会启动一个强制终止机制： ForkedBooter.java:405-431

默认值：30秒

- @Timeout 注解

```java
@Test
@Timeout(3)  // 3秒后超时
public void test_Print(){}
```
当达到超时时间，当前方法会结束执行，等待当前单测类所有方法执行完毕，然后抛出 Timeout 异常。


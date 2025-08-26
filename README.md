# Spring Boot JUnit 5 Mockito 演示项目

一个 Spring Boot 3.5.5 演示项目，展示了 JUnit 5 和 Mockito 测试，包含异步服务实现和自定义线程池配置。

## 项目特性

- Spring Boot 3.5.5 with Java 21
- JUnit 5 测试框架
- Mockito 单元测试
- 异步服务与自定义线程池
- REST API 端点
- 全面的测试技术栈

## 快速开始

### 环境要求
- Java 21
- Maven

### 构建与运行
```bash
# 构建项目
./mvnw clean package

# 运行应用
./mvnw spring-boot:run

# 构建原生可执行文件
./mvnw native:compile -Pnative
```

### 测试
```bash
# 运行所有测试
./mvnw test

# 运行特定测试类
./mvnw test -Dtest=AsyncServiceTest

# 运行特定测试方法
./mvnw test -Dtest=AsyncServiceTest#testCustomThreadPoolCreation
```

## 项目结构

```
src/main/java/cn/lacknb/blog/bootjunit5mockitodemo/
├── config/
│   └── ThreadPoolConfig.java
├── controller/
│   └── HelloController.java
├── service/
│   └── AsyncService.java
└── BootJunit5MockitoDemoApplication.java

src/test/java/cn/lacknb/blog/bootjunit5mockitodemo/
├── AsyncServiceTest.java
└── BootJunit5MockitoDemoApplicationTests.java
```

## API 端点

- `GET /api/hello` - 简单问候
- `GET /api/hello/{name}` - 路径变量问候
- `GET /api/hello/greet` - 查询参数问候（带默认值）

## 核心组件

### ThreadPoolConfig
自定义线程池配置：
- 核心线程数：5
- 最大线程数：10
- 队列容量：25
- 拒绝策略：CallerRunsPolicy

### AsyncService
展示 CompletableFuture.runAsync 与自定义线程池注入的使用。

### HelloController
REST API 控制器，包含三个端点展示不同的参数处理模式。

## 依赖项

- Spring Boot Starter Web
- Spring Boot Starter Test
- JUnit 5
- Mockito
- AssertJ
- Hamcrest
- Lombok
- GraalVM Native Image (可选)

## 许可证

本项目仅供学习使用。